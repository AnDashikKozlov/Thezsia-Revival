//Ambient
let Extremity = Vars.tree.loadMusic("extremity");
let UnnamedAmbient1 = Vars.tree.loadMusic("unnamed-ambient1");
//Dark
let EdgeOfTime = Vars.tree.loadMusic("edge-of-time");
let OutOfTheDarkness = Vars.tree.loadMusic("out-of-the-darkness");
let Shadows = Vars.tree.loadMusic("shadows");
//Game (ambient)
let RiseOfTheEmpire = Vars.tree.loadMusic("rise-of-the-empire");
let SinkingFeeling = Vars.tree.loadMusic("sinking-feeling");
let ThroughTheDarkness = Vars.tree.loadMusic("through-the-darkness");
let UnnamedGame1 = Vars.tree.loadMusic("unnamed-game1");
let UnnamedGame2 = Vars.tree.loadMusic("unnamed-game2");
//Boss
let DefenseBreakthrough = Vars.tree.loadMusic("defense-breakthrough");


Events.on(ClientLoadEvent, e => {
	//Ambient
	Vars.control.sound.ambientMusic.add(Extremity);
	Vars.control.sound.ambientMusic.add(UnnamedAmbient1);
	//Dark
	Vars.control.sound.darkMusic.add(EdgeOfTime);
	Vars.control.sound.darkMusic.add(OutOfTheDarkness);
	Vars.control.sound.darkMusic.add(Shadows);
	//Game (ambient)
	Vars.control.sound.ambientMusic.add(RiseOfTheEmpire);
	Vars.control.sound.ambientMusic.add(SinkingFeeling);
	Vars.control.sound.ambientMusic.add(ThroughTheDarkness);
	Vars.control.sound.ambientMusic.add(UnnamedGame1);
	Vars.control.sound.ambientMusic.add(UnnamedGame2);
	//Boss
	Vars.control.sound.bossMusic.add(DefenseBreakthrough);
});