package Thezsia.content.Thezsia.blocks;


import Thezsia.world.meta.ThezEnv;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.entities.effect.*;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.Env;

import static Thezsia.content.ThezItems.*;
import static Thezsia.content.ThezLiquids.*;
import static Thezsia.world.blocks.ThezAttribute.*;
import static arc.math.Interp.*;

public class ThezsiaProduction{
    public static Block
            //Blocks
            windTrap,
            //drills
            stoneGrinder, /*rotaryDrill,*/ circularDrill;
    public static void load(){
        windTrap = new GenericCrafter("large-wind-trap"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm; envDisabled = Env.oxygen;
            requirements(Category.production, ItemStack.with(tantalum, 100, infium, 80, tensorite, 50));
            size = 5; health = 525; squareSprite = false;

            consumePower(1.92f);
            outputLiquid = new LiquidStack(oxygen,30f / 60f);
            liquidCapacity = 300;

            craftEffect = new ParticleEffect(){{
                particles = 6;
                cone = 360;
                followParent = false; rotWithParent = false;
                sizeFrom = 1.2f; sizeTo = 0.1f;
                lifetime = 40;
                length = 9; baseLength = 5;
                interp = pow2; sizeInterp = Interp.pow3In;
            }};
            ambientSound = Sounds.grinding;
            ambientSoundVolume = 0.08f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(oxygen, 3), new DrawRegion("-bottom2"),
                    new DrawRegion("-rotator"){{spinSprite = true; rotateSpeed = -6;}}, new DrawDefault(),
                    new DrawParticles(){{
                        particleRad = 21; particleLife = 190; particleSize = 6;
                        alpha = 0.5f;
                        color = Color.valueOf("FFFFFF");
                    }}
            );
        }};
        stoneGrinder = new WallCrafter("stone-grinder"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm;
            requirements(Category.production, ItemStack.with(tantalum, 25));
            size = 2; health = 85; squareSprite = false;

            consume(new ConsumeLiquid(oxygen, 0.05f));
            drillTime = 220;
            output = nihilite;
            attribute = volcanicStone;
            ambientSound = Sounds.drill;
            ambientSoundVolume = 0.08f;
        }};
        circularDrill = new BurstDrill("circular-drill"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm; envDisabled = Env.oxygen;
            requirements(Category.production, ItemStack.with(tantalum, 80, silver, 25));
            size = 4; squareSprite = false; itemCapacity = 30; fogRadius = 4;
            tier = 4;
            drillTime = 10f * 60f;
            liquidBoostIntensity = 1.5f;

            drillEffect = new MultiEffect(/*Fx.mineImpact,*/ Fx.drillSteam, Fx.mineImpactWave.wrap(Pal.redLight, 60f),
                    new ParticleEffect(){{
                        particles = 8; lifetime = 40; region = "thezsia1-bubble";
                        length = 24; baseLength = 2f;
                        sizeFrom = 8f; sizeTo = 3.7f;
                        cone = 360; baseRotation = 0;
                        colorFrom = Color.valueOf("615755c6"); colorTo = Color.valueOf("544f5074");
                        interp = Interp.pow3Out; sizeInterp = Interp.pow3Out;
                    }});
            shake = 1.7f;

            hasPower = true; consumePower(100f / 60f);
            consumeLiquid(oxygen, 6f / 60f);
            consumeLiquid(carbonDioxide, 4f / 60f).boost();

            ambientSound = Sounds.grinding;
            ambientSoundVolume = 0.3f;
            alwaysUnlocked = true;
        }};
        /*circularDrill = new Drill("circular-drill"){{
            requirements(Category.production, ItemStack.with(tantalum, 60, infium, 20f, nihilite, 15f));
            size = 4;
            tier = 5;
            drillTime = 630;
            liquidBoostIntensity = 1.35f;
            consumeLiquids(LiquidStack.with(lava, 10f / 60f, carbonDioxide, 6f / 60f));
            consumePower(0.92f);

            ambientSound = Sounds.grinding;
            ambientSoundVolume = 0.4f;
        }};*/
    }
}