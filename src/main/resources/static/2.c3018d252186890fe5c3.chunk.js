webpackJsonp([2],{XnHq:function(l,n,e){"use strict";function u(l){return m._23(0,[(l()(),m._3(0,0,null,null,1,"button",[["class","btn btn--primary"]],[[8,"disabled",0]],[[null,"click"]],function(l,n,e){var u=!0,t=l.component;return"click"===n&&(u=!1!==t.onWantsToJoinGame(t.game)&&u),u},null,null)),(l()(),m._21(-1,null,["\n                Join\n            "]))],null,function(l,n){l(n,0,0,n.component.game.isFull())})}function t(l){return m._23(0,[(l()(),m._21(-1,null,["\n                "])),(l()(),m._3(1,0,null,null,1,"button",[["class","btn btn--primary"],["disabled",""]],null,null,null,null,null)),(l()(),m._21(-1,null,["Full"])),(l()(),m._21(-1,null,["\n            "]))],null,null)}function a(l){return m._23(0,[(l()(),m._3(0,0,null,null,22,"div",[["class","search-result-game padding-1x"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n    "])),(l()(),m._3(2,0,null,null,19,"div",[["class","search-result-game__container"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n        "])),(l()(),m._3(4,0,null,null,8,"div",[["class","search-result-game-details"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n            "])),(l()(),m._3(6,0,null,null,2,"i",[["class","fas fa-circle search-result-game-details__is-full"]],null,null,null,null,null)),m._2(7,278528,null,0,d.h,[m.q,m.r,m.k,m.B],{klass:[0,"klass"],ngClass:[1,"ngClass"]},null),m._17(8,{"search-result-game-details__is-full--active":0}),(l()(),m._21(-1,null,["\n            "])),(l()(),m._3(10,0,null,null,1,"div",[["class","search-result-game-details__name"]],null,null,null,null,null)),(l()(),m._21(11,null,["\n                ","\n            "])),(l()(),m._21(-1,null,["\n        "])),(l()(),m._21(-1,null,["\n        "])),(l()(),m._3(14,0,null,null,6,"div",[["class","search-result-game__actions"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n            "])),(l()(),m.Y(16777216,null,null,1,null,u)),m._2(17,16384,null,0,d.j,[m.M,m.J],{ngIf:[0,"ngIf"],ngIfElse:[1,"ngIfElse"]},null),(l()(),m._21(-1,null,["\n            "])),(l()(),m.Y(0,[["gameFullTemplate",2]],null,0,null,t)),(l()(),m._21(-1,null,["\n        "])),(l()(),m._21(-1,null,["\n    "])),(l()(),m._21(-1,null,["\n"])),(l()(),m._21(-1,null,["\n"]))],function(l,n){var e=n.component;l(n,7,0,"fas fa-circle search-result-game-details__is-full",l(n,8,0,!e.game.isFull())),l(n,17,0,!e.game.isFull(),m._15(n,19))},function(l,n){l(n,11,0,n.component.game.getName())})}function i(l){return m._23(0,[(l()(),m._3(0,0,null,null,33,"div",[],null,null,null,null,null)),(l()(),m._21(-1,null,["\n                "])),(l()(),m._3(2,0,null,null,4,"div",[["class","padding-1x"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n                    "])),(l()(),m._3(4,0,null,null,1,"h3",[["class","games-hud-title"]],null,null,null,null,null)),(l()(),m._21(-1,null,["Search game"])),(l()(),m._21(-1,null,["\n                "])),(l()(),m._21(-1,null,["\n                "])),(l()(),m._3(8,0,null,null,24,"div",[["class","games-hud padding-1x"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n                    "])),(l()(),m._3(10,0,null,null,8,"div",[["class","games-search"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n                        "])),(l()(),m._3(12,0,null,null,5,"input",[["id","search"],["name","search"],["placeholder","..."],["type","text"]],[[2,"ng-untouched",null],[2,"ng-touched",null],[2,"ng-pristine",null],[2,"ng-dirty",null],[2,"ng-valid",null],[2,"ng-invalid",null],[2,"ng-pending",null]],[[null,"ngModelChange"],[null,"input"],[null,"blur"],[null,"compositionstart"],[null,"compositionend"]],function(l,n,e){var u=!0,t=l.component;return"input"===n&&(u=!1!==m._15(l,13)._handleInput(e.target.value)&&u),"blur"===n&&(u=!1!==m._15(l,13).onTouched()&&u),"compositionstart"===n&&(u=!1!==m._15(l,13)._compositionStart()&&u),"compositionend"===n&&(u=!1!==m._15(l,13)._compositionEnd(e.target.value)&&u),"ngModelChange"===n&&(u=!1!==(t.gamesFilter=e)&&u),u},null,null)),m._2(13,16384,null,0,_.c,[m.B,m.k,[2,_.a]],null,null),m._18(1024,null,_.i,function(l){return[l]},[_.c]),m._2(15,671744,null,0,_.n,[[8,null],[8,null],[8,null],[2,_.i]],{name:[0,"name"],model:[1,"model"]},{update:"ngModelChange"}),m._18(2048,null,_.j,null,[_.n]),m._2(17,16384,null,0,_.k,[_.j],null,null),(l()(),m._21(-1,null,["\n                    "])),(l()(),m._21(-1,null,["\n                    "])),(l()(),m._3(20,0,null,null,11,"div",[["class","games-actions"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n                        "])),(l()(),m._3(22,0,null,null,3,"button",[["class","btn btn--secondary"]],[[8,"disabled",0]],[[null,"click"]],function(l,n,e){var u=!0;return"click"===n&&(u=!1!==l.component.refreshGames()&&u),u},null,null)),(l()(),m._21(-1,null,["\n                            "])),(l()(),m._3(24,0,null,null,0,"i",[["class","fas fa-sync-alt"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n                        "])),(l()(),m._21(-1,null,["\n                        "])),(l()(),m._3(27,0,null,null,3,"button",[["class","btn btn--primary"],["type","button"]],null,[[null,"click"]],function(l,n,e){var u=!0;return"click"===n&&(u=!1!==l.component.showCreateGameView()&&u),u},null,null)),(l()(),m._21(-1,null,["\n                            "])),(l()(),m._3(29,0,null,null,0,"i",[["class","fas fa-plus"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n                        "])),(l()(),m._21(-1,null,["\n                    "])),(l()(),m._21(-1,null,["\n                "])),(l()(),m._21(-1,null,["\n            "]))],function(l,n){l(n,15,0,"search",n.component.gamesFilter)},function(l,n){var e=n.component;l(n,12,0,m._15(n,17).ngClassUntouched,m._15(n,17).ngClassTouched,m._15(n,17).ngClassPristine,m._15(n,17).ngClassDirty,m._15(n,17).ngClassValid,m._15(n,17).ngClassInvalid,m._15(n,17).ngClassPending),l(n,22,0,e.gamesRefreshInProgress)})}function s(l){return m._23(0,[(l()(),m._3(0,0,null,null,1,"bol-search-result-game",[],null,null,null,a,v)),m._2(1,114688,null,0,f,[p.a,h.a,b.a],{game:[0,"game"]},null)],function(l,n){l(n,1,0,n.context.$implicit)},null)}function r(l){return m._23(0,[(l()(),m._3(0,0,null,null,1,"div",[["class","margin-1x font-small background-error padding-1x font-center"]],null,null,null,null,null)),(l()(),m._21(1,null,["\n                    ","\n                "]))],null,function(l,n){l(n,1,0,n.component.createGameErrorMessage)})}function o(l){return m._23(0,[(l()(),m._21(-1,null,["\n            "])),(l()(),m._3(1,0,null,null,45,"form",[["novalidate",""]],[[2,"ng-untouched",null],[2,"ng-touched",null],[2,"ng-pristine",null],[2,"ng-dirty",null],[2,"ng-valid",null],[2,"ng-invalid",null],[2,"ng-pending",null]],[[null,"ngSubmit"],[null,"submit"],[null,"reset"]],function(l,n,e){var u=!0,t=l.component;return"submit"===n&&(u=!1!==m._15(l,3).onSubmit(e)&&u),"reset"===n&&(u=!1!==m._15(l,3).onReset()&&u),"ngSubmit"===n&&(u=!1!==t.createGame()&&u),u},null,null)),m._2(2,16384,null,0,_.s,[],null,null),m._2(3,4210688,[["createGameForm",4]],0,_.m,[[8,null],[8,null]],null,{ngSubmit:"ngSubmit"}),m._18(2048,null,_.b,null,[_.m]),m._2(5,16384,null,0,_.l,[_.b],null,null),(l()(),m._21(-1,null,["\n                "])),(l()(),m._3(7,0,null,null,4,"div",[["class","padding-1x"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n                    "])),(l()(),m._3(9,0,null,null,1,"h3",[["class","games-hud-title"]],null,null,null,null,null)),(l()(),m._21(-1,null,["Create game"])),(l()(),m._21(-1,null,["\n                "])),(l()(),m._21(-1,null,["\n                "])),(l()(),m._3(13,0,null,null,29,"div",[["class","games-hud padding-1x"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n                    "])),(l()(),m._3(15,0,null,null,13,"div",[["class","games-search"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n                        "])),(l()(),m._3(17,0,null,null,10,"input",[["id","gameName"],["maxlength","12"],["minlength","3"],["name","gameName"],["pattern","^[a-zA-Z0-9 ]*"],["placeholder","Game name"],["required",""],["type","text"]],[[1,"required",0],[1,"minlength",0],[1,"maxlength",0],[1,"pattern",0],[2,"ng-untouched",null],[2,"ng-touched",null],[2,"ng-pristine",null],[2,"ng-dirty",null],[2,"ng-valid",null],[2,"ng-invalid",null],[2,"ng-pending",null]],[[null,"ngModelChange"],[null,"input"],[null,"blur"],[null,"compositionstart"],[null,"compositionend"]],function(l,n,e){var u=!0,t=l.component;return"input"===n&&(u=!1!==m._15(l,18)._handleInput(e.target.value)&&u),"blur"===n&&(u=!1!==m._15(l,18).onTouched()&&u),"compositionstart"===n&&(u=!1!==m._15(l,18)._compositionStart()&&u),"compositionend"===n&&(u=!1!==m._15(l,18)._compositionEnd(e.target.value)&&u),"ngModelChange"===n&&(u=!1!==(t.gameToCreateName=e)&&u),u},null,null)),m._2(18,16384,null,0,_.c,[m.B,m.k,[2,_.a]],null,null),m._2(19,16384,null,0,_.q,[],{required:[0,"required"]},null),m._2(20,540672,null,0,_.g,[],{minlength:[0,"minlength"]},null),m._2(21,540672,null,0,_.f,[],{maxlength:[0,"maxlength"]},null),m._2(22,540672,null,0,_.o,[],{pattern:[0,"pattern"]},null),m._18(1024,null,_.h,function(l,n,e,u){return[l,n,e,u]},[_.q,_.g,_.f,_.o]),m._18(1024,null,_.i,function(l){return[l]},[_.c]),m._2(25,671744,[["gameName",4]],0,_.n,[[2,_.b],[2,_.h],[8,null],[2,_.i]],{name:[0,"name"],model:[1,"model"]},{update:"ngModelChange"}),m._18(2048,null,_.j,null,[_.n]),m._2(27,16384,null,0,_.k,[_.j],null,null),(l()(),m._21(-1,null,["\n                    "])),(l()(),m._21(-1,null,["\n                    "])),(l()(),m._3(30,0,null,null,11,"div",[["class","games-actions"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n                        "])),(l()(),m._3(32,0,null,null,3,"button",[["class","btn btn--warn"],["type","button"]],null,[[null,"click"]],function(l,n,e){var u=!0;return"click"===n&&(u=!1!==l.component.hideCreateGameView()&&u),u},null,null)),(l()(),m._21(-1,null,["\n                            "])),(l()(),m._3(34,0,null,null,0,"i",[["class","fas fa-times"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n                        "])),(l()(),m._21(-1,null,["\n                        "])),(l()(),m._3(37,0,null,null,3,"button",[["class","btn btn--primary"],["type","submit"]],[[8,"disabled",0]],null,null,null,null)),(l()(),m._21(-1,null,["\n                            "])),(l()(),m._3(39,0,null,null,0,"i",[["class","fas fa-check"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n                        "])),(l()(),m._21(-1,null,["\n                    "])),(l()(),m._21(-1,null,["\n                "])),(l()(),m._21(-1,null,["\n                "])),(l()(),m.Y(16777216,null,null,1,null,r)),m._2(45,16384,null,0,d.j,[m.M,m.J],{ngIf:[0,"ngIf"]},null),(l()(),m._21(-1,null,["\n            "])),(l()(),m._21(-1,null,["\n        "]))],function(l,n){var e=n.component;l(n,19,0,""),l(n,20,0,"3"),l(n,21,0,"12"),l(n,22,0,"^[a-zA-Z0-9 ]*"),l(n,25,0,"gameName",e.gameToCreateName),l(n,45,0,e.createGameErrorMessage)},function(l,n){var e=n.component;l(n,1,0,m._15(n,5).ngClassUntouched,m._15(n,5).ngClassTouched,m._15(n,5).ngClassPristine,m._15(n,5).ngClassDirty,m._15(n,5).ngClassValid,m._15(n,5).ngClassInvalid,m._15(n,5).ngClassPending),l(n,17,1,[m._15(n,19).required?"":null,m._15(n,20).minlength?m._15(n,20).minlength:null,m._15(n,21).maxlength?m._15(n,21).maxlength:null,m._15(n,22).pattern?m._15(n,22).pattern:null,m._15(n,27).ngClassUntouched,m._15(n,27).ngClassTouched,m._15(n,27).ngClassPristine,m._15(n,27).ngClassDirty,m._15(n,27).ngClassValid,m._15(n,27).ngClassInvalid,m._15(n,27).ngClassPending]),l(n,37,0,m._15(n,3).invalid||e.createGameInProgress)})}function c(l){return m._23(0,[(l()(),m._3(0,0,null,null,25,"div",[["class","games-route background-brand color-ds-text-primary"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n    "])),(l()(),m._3(2,0,null,null,22,"div",[["class","padding-1x games-route-container"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n        "])),(l()(),m._3(4,0,null,null,4,"div",[["class","games-title"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n            "])),(l()(),m._3(6,0,null,null,1,"h1",[],null,null,null,null,null)),(l()(),m._21(-1,null,["Games Hub"])),(l()(),m._21(-1,null,["\n        "])),(l()(),m._21(-1,null,["\n        "])),(l()(),m._3(10,0,null,null,11,"div",[["class","games background-black-alpha-3 margin-1x"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n            "])),(l()(),m.Y(16777216,null,null,1,null,i)),m._2(13,16384,null,0,d.j,[m.M,m.J],{ngIf:[0,"ngIf"],ngIfElse:[1,"ngIfElse"]},null),(l()(),m._21(-1,null,["\n            "])),(l()(),m._3(15,0,null,null,5,"div",[["class","games-search-results"]],null,null,null,null,null)),(l()(),m._21(-1,null,["\n                "])),(l()(),m.Y(16777216,null,null,2,null,s)),m._2(18,802816,null,0,d.i,[m.M,m.J,m.q],{ngForOf:[0,"ngForOf"],ngForTrackBy:[1,"ngForTrackBy"]},null),m._16(0,x,[]),(l()(),m._21(-1,null,["\n            "])),(l()(),m._21(-1,null,["\n        "])),(l()(),m._21(-1,null,["\n        "])),(l()(),m.Y(0,[["wantsToCreateGameTemplate",2]],null,0,null,o)),(l()(),m._21(-1,null,["\n    "])),(l()(),m._21(-1,null,["\n"])),(l()(),m._21(-1,null,["\n"]))],function(l,n){var e=n.component;l(n,13,0,!e.createGameViewVisible,m._15(n,23)),l(n,18,0,m._22(n,18,0,m._15(n,19).transform(e.games,e.gamesFilter)),e.trackByGame)},null)}Object.defineProperty(n,"__esModule",{value:!0});var m=e("WT6e"),g=function(){},_=e("7DMc"),d=e("Xjw4"),f=function(){function l(l,n,e){this.loggerFactoryService=l,this.bolCoreEventsService=n,this.gameService=e,this.logger=l.make("SearchResultGameComponent")}return l.prototype.ngOnInit=function(){},l.prototype.onWantsToJoinGame=function(l){var n=this;return this.joinGameInProgress=!0,this.gameService.joinGame(l).then(function(){n.logger.info("Joined game with name "+l.getName()+"! Sending to game route!"),n.bolCoreEventsService.emitUserJoinedGame(l)}).catch(function(e){var u=e.error.message;n.logger.error("User couldn't join game with name "+l.getName()+' with message "',u,'" and error',e)}).finally(function(){n.joinGameInProgress=!1})},l}(),p=e("2UhV"),h=e("O6XV"),b=e("8uyA"),v=m._1({encapsulation:0,styles:[[".search-result-game[_ngcontent-%COMP%]{display:-webkit-box;display:-ms-flexbox;display:flex;border-bottom:1px solid #fff;font-size:70%}@media (min-width:600px){.search-result-game[_ngcontent-%COMP%]{font-size:100%}}.search-result-game__container[_ngcontent-%COMP%]{display:-webkit-box;display:-ms-flexbox;display:flex;width:100%;-webkit-box-pack:justify;-ms-flex-pack:justify;justify-content:space-between}.search-result-game-details[_ngcontent-%COMP%]{width:70%;display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-align:center;-ms-flex-align:center;align-items:center}.search-result-game-details__name[_ngcontent-%COMP%]{text-overflow:ellipsis;white-space:nowrap;overflow:hidden;margin-left:1rem}.search-result-game-details__is-full[_ngcontent-%COMP%]{color:#ff4500}.search-result-game-details__is-full--active[_ngcontent-%COMP%]{color:#adff2f}.search-result-game__actions[_ngcontent-%COMP%]{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-pack:center;-ms-flex-pack:center;justify-content:center}@media (min-width:600px){.search-result-game__actions[_ngcontent-%COMP%]{width:20%}}"]],data:{}}),x=function(){function l(){}return l.prototype.transform=function(l,n){return l&&n?l.filter(function(l){return-1!==l.getName().toUpperCase().indexOf(n.toUpperCase())}):l},l}(),y=function(){function l(l,n,e,u){this.loggerFactoryService=l,this.bolCoreEventsService=n,this.gamesService=e,this.gameService=u,this.logger=l.make("GamesRouteComponent")}return l.prototype.ngOnInit=function(){var n=this;this.refreshGames().then(function(){n.intervalHandle=setInterval(function(){n.refreshGames()},l.REFRESH_GAMES_INTERVAL)})},l.prototype.ngOnDestroy=function(){this.intervalHandle&&clearInterval(this.intervalHandle)},l.prototype.refreshGames=function(){var l=this;if(!this.gamesRefreshInProgress)return this.gamesRefreshInProgress=!0,this.getGames().then(function(n){l.games=n}).finally(function(){l.gamesRefreshInProgress=!1})},l.prototype.trackByGame=function(l,n){return""+n.getName()+n.isFull()},l.prototype.showCreateGameView=function(){this.createGameViewVisible=!0},l.prototype.hideCreateGameView=function(){this.createGameViewVisible=!1},l.prototype.createGame=function(){var l=this;this.createGameInProgress=!0;var n=this.gameToCreateName;return this.gamesService.createGameWithName(n).then(function(n){l.gameService.setGame(n),l.bolCoreEventsService.emitUserCreatedGame(n)}).catch(function(e){l.logger.error('Could not create game with name "'+n+'" with error:',e),l.createGameErrorMessage=e.error.message}).finally(function(){l.createGameInProgress=!1})},l.prototype.handleKeyboardEvent=function(n){this.createGameViewVisible&&n.keyCode===l.ESCAPE_KEYCODE&&this.hideCreateGameView()},l.prototype.getGames=function(){return this.gamesService.getGames()},l.REFRESH_GAMES_INTERVAL=5e3,l.ESCAPE_KEYCODE=27,l}(),C=e("iFZZ"),w=m._1({encapsulation:0,styles:[[".games-route[_ngcontent-%COMP%], .games-route-container[_ngcontent-%COMP%]{display:-webkit-box;display:-ms-flexbox;display:flex;width:100%;min-height:100%;-webkit-box-orient:vertical;-webkit-box-direction:normal;-ms-flex-direction:column;flex-direction:column;-webkit-box-align:center;-ms-flex-align:center;align-items:center;position:relative}.games-title[_ngcontent-%COMP%]{position:relative;margin-top:10%}.games[_ngcontent-%COMP%]{width:100%;max-width:640px;border-radius:3px}.games-hud-title[_ngcontent-%COMP%]{margin-bottom:0}.games-hud[_ngcontent-%COMP%]{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-pack:justify;-ms-flex-pack:justify;justify-content:space-between;-ms-flex-wrap:wrap;flex-wrap:wrap}.games-search[_ngcontent-%COMP%]{width:100%}@media (min-width:600px){.games-search[_ngcontent-%COMP%]{width:70%}}.games-actions[_ngcontent-%COMP%]{width:100%;display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-pack:end;-ms-flex-pack:end;justify-content:flex-end;margin-top:1rem}@media (min-width:600px){.games-actions[_ngcontent-%COMP%]{margin:0;-webkit-box-flex:1;-ms-flex:1;flex:1}}.games-actions[_ngcontent-%COMP%]   .btn[_ngcontent-%COMP%]:first-child{margin-right:1rem}.games-search-results[_ngcontent-%COMP%]{margin:2rem 0;border-top:1px solid #fff}"]],data:{}}),k=m.Z("bol-games-route",y,function(l){return m._23(0,[(l()(),m._3(0,0,null,null,1,"bol-games-route",[],null,[["document","keydown"]],function(l,n,e){var u=!0;return"document:keydown"===n&&(u=!1!==m._15(l,1).handleKeyboardEvent(e)&&u),u},c,w)),m._2(1,245760,null,0,y,[p.a,h.a,C.a,b.a],null,null)],function(l,n){l(n,1,0)},null)},{},{},[]),G=e("bfOx");e.d(n,"GamesRouteModuleNgFactory",function(){return M});var M=m._0(g,[],function(l){return m._13([m._14(512,m.j,m.W,[[8,[k]],[3,m.j],m.v]),m._14(4608,d.l,d.k,[m.s,[2,d.p]]),m._14(4608,_.t,_.t,[]),m._14(4608,_.d,_.d,[]),m._14(512,d.b,d.b,[]),m._14(512,_.r,_.r,[]),m._14(512,_.e,_.e,[]),m._14(512,G.l,G.l,[[2,G.q],[2,G.k]]),m._14(512,_.p,_.p,[]),m._14(512,g,g,[]),m._14(1024,G.i,function(){return[[{path:"",component:y}]]},[])])})}});