/*
YES, IT'S SCRIPT FROM AQUARION (JSON)
Please don't hit
*/

var musicRoot = Vars.mods.locateMod("thezsia1").root.child("music");

var modAmbient = [];
var modDark = [];
var modBoss = [];

var control = Vars.control.sound;

var vAmbient;
var vGame;
var vBoss;

function loadMusic(name) {
    return Vars.tree.loadMusic(name);
}

musicRoot.list().forEach((cat) => {
    Log.info(cat);
    cat.findAll((f) => {
        return f.extEquals("ogg") || f.extEquals("mp3");
    }).forEach((mFile) => {
        Log.info(mFile);
        var music = loadMusic(cat.name() + "/" + mFile.nameWithoutExtension());
        switch (cat.name()) {
            case "ambient":
                modAmbient.push(music);
                break;
            case "game":
                modDark.push(music);
                break;
            case "boss":
                modBoss.push(music);
                break;
        }
    });
});

Events.on(MusicRegisterEvent, (e) => {
    vAmbient = control.ambientMusic.copy();
    vGame = control.darkMusic.copy();
    vBoss = control.bossMusic.copy();
});

Events.on(WorldLoadEvent, (e) => {
    if (Vars.state.rules.planet == Vars.content.planet("aquarion-tantros")) {
        control.ambientMusic = Seq.with(modAmbient).addAll(vAmbient);
        control.darkMusic = Seq.with(modDark).addAll(vGame);
        control.bossMusic = Seq.with(modBoss).addAll(vBoss);
    }
});

Events.on(StateChangeEvent, (e) => {
    if (e.from != GameState.State.menu && e.to == GameState.State.menu) {
        control.ambientMusic = vAmbient;
        control.darkMusic = vGame;
        control.bossMusic = vBoss;
    }
});
