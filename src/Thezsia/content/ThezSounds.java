package Thezsia.content;

import arc.Core;
import arc.assets.AssetDescriptor;
import arc.assets.loaders.SoundLoader;
import arc.audio.Sound;
import mindustry.Vars;

public class ThezSounds {
    public static Sound
            //"UK" — sounds from ULTRAKILL :P
            UKExplosion, UKStep, UKJump, UKMachineGun, UKBeam, UKRocketFire, UKShoot1, UKShoot1b, UKShoot2, UKClink, UKWarning,
            blasterCharge, blasterShot1, blasterShot2, gunDestruction, laserCharge, laserShot,
            machineGunShot1, machineGunShot2, machineGunShot3, machineGunShot4, mechFootsteps = new Sound();
    public static void load(){
        UKExplosion = loadSound("uk-explosion");
        UKStep = loadSound("uk-g-step");
        UKJump = loadSound("uk-jump-pad");
        UKMachineGun = loadSound("uk-machine-gun");
        UKBeam = loadSound("uk-m-beam");
        UKRocketFire = loadSound("uk-rocket-fire");
        UKShoot1 = loadSound("uk-shoot-1");
        UKShoot1b = loadSound("uk-shoot-1b");
        UKShoot2 = loadSound("uk-shoot-2");
        UKClink = loadSound("uk-w-clink");
        UKWarning = loadSound("uk-zapper-warning");

        blasterCharge = loadSound("blaster-charge");
        blasterShot1 = loadSound("blaster-shot-1");
        blasterShot2 = loadSound("blaster-shot-2");
        gunDestruction = loadSound("gun-destruction");
        laserCharge = loadSound("laser-charge");
        laserShot = loadSound("laser-shot");

        machineGunShot1 = loadSound("machine-gun-shot-1");
        machineGunShot2 = loadSound("machine-gun-shot-2");
        machineGunShot3 = loadSound("machine-gun-shot-3");
        machineGunShot4 = loadSound("machine-gun-shot-4");
        mechFootsteps = loadSound("mech-footsteps");
    }

    //Just copy all this function
    public static Sound loadSound(String sName){
        if(!Vars.headless){
            String name = "sounds/" + sName;
            String path = Vars.tree.get(name + ".ogg").exists() ? name + ".ogg" : name + ".mp3";

            Sound sound = new Sound();

            AssetDescriptor<?> desc = Core.assets.load(path, Sound.class, new SoundLoader.SoundParameter(sound));
            desc.errored = Throwable::printStackTrace;
            return sound;
        }else{
            return new Sound();
        }
    }
}
