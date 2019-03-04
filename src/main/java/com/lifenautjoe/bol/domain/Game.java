package com.lifenautjoe.bol.domain;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.lifenautjoe.bol.domain.exceptions.*;

import java.util.*;

public class Game {

    private static final int BOARD_SLOTS = 14;
    private static final int STONES_PER_BOARD_SLOT = 6;

    private User userA;
    private User userB;
    private User nextTurnUser;
    private GameSlot userAStorageSlot;
    private GameSlot userBStorageSlot;
    private List<GameSlot> userASlots;
    private List<GameSlot> userBSlots;
    private boolean gameStarted;
    private boolean gameFinished;
    private String name;
    private Random randomness;

    // For quick find
    private Map<Integer, GameSlot> slots;

    // For making iterators
    private Collection<GameSlot> slotsCollection;

    public Game(String name) {
        this.name = name;
    }

    public GamePlayOutcome startGame() {
        if (BOARD_SLOTS % 2 > 0 || BOARD_SLOTS < 4) {
            // Safety
            throw new RuntimeException("BOARD_SLOTS must be divisible by 2 and gt 4!");
        }

        if (!isFull()) {
            throw new GameIsNotFullException();
        } else if (isGameStarted()) {
            throw new GameAlreadyStartedException();
        }

        this.randomness = new Random();

        bootstrapSlots();
        this.slotsCollection = this.slots.values();
        this.userAStorageSlot = this.slots.get(getUserAStorageSlotId());
        this.userBStorageSlot = this.slots.get(getUserBStorageSlotId());

        setGameStarted(true);

        GamePlayOutcome initialPlayOutcome = makeGamePlayOutcome();

        User firstTurnUser = getRandomUser();
        nextTurnUser = firstTurnUser;

        initialPlayOutcome.setNextTurnHolderUserName(firstTurnUser.getName());

        List<GameSlot> initialGameSlots = getSlots();
        initialPlayOutcome.setSlots(initialGameSlots);

        return initialPlayOutcome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Game.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Game other = (Game) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }


    public GamePlayOutcome playAtSlotWithIdForUser(int slotId, User user) {

        if (!userHasNextTurn(user)) {
            throw new UserHasNoNextTurnException();
        }

        if (!isGameStarted()) {
            throw new GameNotStartedException();
        }

        if (isGameFinished()) {
            throw new GameFinishedException();
        }

        GameSlot slot = this.getSlotWithId(slotId);

        if (slot.isEmpty()) {
            throw new SlotIsEmptyException();
        }

        if (!slotBelongsToUser(slot, user)) {
            throw new UserHasNoSlotException();
        }

        User opponentUser = getOpponentForUser(user);

        User nextTurnHolderUser = opponentUser;

        GamePlayOutcome playOutcome = makeGamePlayOutcome();

        Iterator<GameSlot> slotIterator = getIteratorAtSlot(slot);

        LinkedList<GameSlotStone> userStones = slot.pickStones();

        boolean gameFinished = false;

        while (!userStones.isEmpty() && !gameFinished) {

            GameSlot nextSlot = slotIterator.next();

            if (getStorageSlotForUser(opponentUser) == nextSlot) {
                continue;
            }

            if (userStones.size() == 1) {
                // Last one
                if (slotIsUserStorage(nextSlot)) {
                    // Drop it and extra turn!
                    GameSlotStone userStoneToAddToSlot = userStones.pop();
                    nextSlot.dropStone(userStoneToAddToSlot);

                    nextTurnHolderUser = user;
                } else if (nextSlot.isEmpty()) {
                    // We take the stone to the storage and all of the ones across
                    GameSlot slotAcrossBoard = getSlotAcrossBoard(nextSlot);
                    List<GameSlotStone> slotAcrossBoardStones = slotAcrossBoard.pickStones();
                    GameSlot userStorageSlot = getStorageSlotForUser(user);
                    userStorageSlot.dropStones(slotAcrossBoardStones);
                    GameSlotStone userStoneToAddToSlot = userStones.pop();
                    userStorageSlot.dropStone(userStoneToAddToSlot);
                } else {
                    // A simple drop
                    GameSlotStone userStoneToAddToSlot = userStones.pop();
                    nextSlot.dropStone(userStoneToAddToSlot);
                }
            } else {
                // A simple drop
                GameSlotStone userStoneToAddToSlot = userStones.pop();
                nextSlot.dropStone(userStoneToAddToSlot);
            }

            if (userStones.isEmpty() && normalSlotsAreEmptyForUser(user)) {
                // Take all the opponent slot stones & drop on their storage slot
                GameSlot opponentStorageSlot = getStorageSlotForUser(opponentUser);
                List<GameSlot> opponentNormalSlots = getNormalSlotsForUser(opponentUser);

                for (GameSlot opponentSlot : opponentNormalSlots) {
                    List<GameSlotStone> opponentSlotStones = opponentSlot.getStones();
                    opponentStorageSlot.dropStones(opponentSlotStones);
                }
                gameFinished = true;
                onGameFinished();
            }
        }

        nextTurnUser = nextTurnHolderUser;
        playOutcome.setNextTurnHolderUserName(nextTurnHolderUser.getName());

        List<GameSlot> latestGameSlots = getSlots();
        playOutcome.setSlots(latestGameSlots);

        int userAScore = getUserAScore();
        playOutcome.setUserAScore(userAScore);

        int userBScore = getUserBScore();
        playOutcome.setUserBScore(userBScore);

        if (gameFinished) {
            playOutcome.setGameFinished(true);
            User winner = userAScore > userBScore ? userA : userB;
            playOutcome.setWinnerUserName(winner.getName());
        }

        return playOutcome;
    }

    public GamePlayOutcome terminateGameForUser(User user) {
        GamePlayOutcome gamePlayOutcome = makeGamePlayOutcome();
        gamePlayOutcome.setGameFinished(true);

        if (hasOpponent()) {
            User opponent = getOpponentForUser(user);
            String opponentUserName = opponent.getName();
            gamePlayOutcome.setWinnerUserName(opponentUserName);
        }

        onGameFinished();
        return gamePlayOutcome;
    }

    public void addUser(User user) {
        if (isFull()) throw new GameFullException();
        if (userA == null) {
            userA = user;
        } else if (userB == null) {
            userB = user;
        }
    }

    public List<GameSlot> getSlots() {
        List<GameSlot> clonedSlots = new ArrayList<>();
        for (Map.Entry<Integer, GameSlot> map : slots.entrySet()) {
            GameSlot slot = map.getValue();
            clonedSlots.add(slot.clone());
        }
        return clonedSlots;
    }

    public User getUserA() {
        return userA;
    }

    public User getUserB() {
        return userB;
    }

    public String getName() {
        return name;
    }

    public boolean isFull() {
        return userA != null && userB != null;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    public boolean userHasNextTurn(User user) {
        return this.nextTurnUser == user;
    }

    public boolean slotWithIdIsEmpty(int slotId) {
        GameSlot slot = getSlotWithId(slotId);
        return slot.isEmpty();
    }

    public boolean slotWithIdBelongsToUser(int slotId, User user) {
        GameSlot slot = getSlotWithId(slotId);
        return slotBelongsToUser(slot, user);
    }

    private void onGameFinished() {
        setGameFinished(true);

        // Game can be finished before even starting
        if (userA != null) {
            userA.removeGame();
        }
        if (userB != null) {
            userB.removeGame();
        }

    }

    private Iterator<GameSlot> getIteratorAtSlot(GameSlot slot) {
        Iterator<GameSlot> iterable = Iterators.cycle(slotsCollection);
        for (int i = 0; i < slot.getId(); i++) {
            iterable.next();
        }
        return iterable;
    }

    private GameSlot getStorageSlotForUser(User user) {
        return user == userA ? userAStorageSlot : userBStorageSlot;
    }

    private GameSlot getSlotAcrossBoard(GameSlot slot) {
        int slotId = slot.getId();
        int acrossBoardSlotId = (BOARD_SLOTS - slotId);
        return getSlotWithId(acrossBoardSlotId);
    }

    private GameSlot getSlotWithId(int slotId) {
        return slots.get(slotId);
    }

    private int getUserAScore() {
        return getScoreForUser(userA);
    }

    private int getUserBScore() {
        return getScoreForUser(userB);
    }

    private int getScoreForUser(User user) {
        GameSlot storageSlot = getStorageSlotForUser(user);
        List<GameSlotStone> storageSlotStones = storageSlot.getStones();
        int score = 0;
        for (GameSlotStone stone : storageSlotStones) {
            score = score + 1;
        }
        return score;
    }

    private void bootstrapSlots() {

        int slotsPerUser = BOARD_SLOTS / 2;


        Map<Integer, GameSlot> slots = new HashMap<>();

        List<GameSlot> userANormalSlots = new ArrayList<>();
        List<GameSlot> userBNormalSlots = new ArrayList<>();

        int stoneId = 1;

        for (int slotId = 1; slotId <= BOARD_SLOTS; slotId++) {

            User slotOwner = null;
            boolean userBIsOwner = slotId > slotsPerUser;

            if (userBIsOwner) {
                slotOwner = userB;
            } else {
                slotOwner = userA;
            }

            LinkedList<GameSlotStone> slotStones = new LinkedList<>();

            boolean isStorageSlotId = isStorageSlotId(slotId);

            if (!isStorageSlotId) {
                for (int i = 1; i < STONES_PER_BOARD_SLOT; i++) {
                    GameSlotStone stone = new GameSlotStone(stoneId);
                    slotStones.add(stone);
                    stoneId = stoneId + 1;
                }
            }

            GameSlot slot = new GameSlot(slotId, slotStones);

            if (!isStorageSlotId) {
                List<GameSlot> userNormalSlots = userBIsOwner ? userBNormalSlots : userANormalSlots;
                userNormalSlots.add(slot);
            }

            slots.put(slotId, slot);
        }

        this.userASlots = userANormalSlots;
        this.userBSlots = userBNormalSlots;
        this.slots = slots;
    }

    private boolean normalSlotsAreEmptyForUser(User user) {
        boolean normalSlotsAreEmpty = true;
        List<GameSlot> userNormalSlots = getNormalSlotsForUser(user);
        for (GameSlot slot : userNormalSlots) {
            if (!slot.isEmpty()) {
                normalSlotsAreEmpty = false;
                break;
            }
        }
        return normalSlotsAreEmpty;
    }


    private String getOpponentUserNameForUser(User user) {
        User opponent = getOpponentForUser(user);
        return opponent.getName();
    }

    private boolean hasOpponent() {
        return this.isFull();
    }

    private User getOpponentForUser(User user) {
        User opponent = null;
        if (isUserB(user)) {
            opponent = userA;
        } else {
            opponent = userB;
        }

        return opponent;
    }

    private boolean isUserB(User user) {
        return user == getUserB();
    }

    private boolean slotIsUserStorage(GameSlot slot) {
        return slot == userAStorageSlot || slot == userBStorageSlot;
    }

    private boolean slotBelongsToUser(GameSlot slot, User user) {
        return slot == getStorageSlotForUser(user) || getNormalSlotsForUser(user).contains(slot);
    }

    private List<GameSlot> getNormalSlotsForUser(User user) {
        List<GameSlot> normalSlots;

        if (isUserB(user)) {
            normalSlots = userBSlots;
        } else {
            normalSlots = userASlots;
        }

        return normalSlots;
    }

    private User getRandomUser() {
        return randomness.nextBoolean() ? userA : userB;
    }

    private boolean isStorageSlotId(int slotId) {
        return slotId == getUserAStorageSlotId() || slotId == getUserBStorageSlotId();
    }

    private int getUserAStorageSlotId() {
        return BOARD_SLOTS / 2;
    }

    private int getUserBStorageSlotId() {
        return BOARD_SLOTS;
    }

    private GamePlayOutcome makeGamePlayOutcome() {
        GamePlayOutcome gamePlayOutcome = new GamePlayOutcome();
        gamePlayOutcome.setGameName(name);

        // Outcome can be asked before even game started, hence checks.
        if (userA != null) {
            gamePlayOutcome.setUserAName(userA.getName());
        }

        if (userB != null) {
            gamePlayOutcome.setUserBName(userB.getName());
        }

        return gamePlayOutcome;
    }

}
