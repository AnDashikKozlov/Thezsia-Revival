package Thezsia.content.Thezsia.blocks;

import Thezsia.content.ThezItems;
import Thezsia.content.ThezLiquids;
import Thezsia.world.blocks.ThezAttribute;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.entities.effect.ParticleEffect;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.WallCrafter;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.world.draw.*;

import static arc.math.Interp.pow2;
import static mindustry.content.Items.beryllium;

public class ThezProduction{
    public static Block
            //Blocks
            windTrap, largeWindTrap,
            //drills
            stoneGrinder, rotaryDrill, circularDrill;
    public static void load(){
        windTrap = new GenericCrafter("wind-trap"){{
            requirements(Category.production, ItemStack.with(beryllium, 100));
            size = 4; health = 320; squareSprite = false;
            alwaysUnlocked = true;

            consumePower(1.17f); //power: 0.23f
            outputLiquid = new LiquidStack(ThezLiquids.wind,0.5f);
            liquidCapacity = 200;

            craftEffect = new ParticleEffect(){{
                particles = 6;
                cone = 360;
                followParent = false; rotWithParent = false;
                sizeFrom = 1.2f; sizeTo = 0.1f;
                lifetime = 40;
                length = 3; baseLength = 5;
                interp = pow2; sizeInterp = Interp.pow3In;
            }};
            ambientSound = Sounds.grinding;
            ambientSoundVolume = 0.08f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(ThezLiquids.wind, 3), new DrawDefault(),
                    new DrawParticles(){{
                        particleRad = 17; particleLife = 160; particleSize = 4;
                        alpha = 0.5f;
                        color = Color.valueOf("FFFFFF");
                    }}
            );
        }};
        largeWindTrap = new GenericCrafter("large-wind-trap"){{
            requirements(Category.production, ItemStack.with(beryllium, 100, ThezItems.infium, 80, ThezItems.tensorite, 50));
            size = 5; health = 525; squareSprite = false;

            consumePower(1.92f);
            outputLiquid = new LiquidStack(ThezLiquids.wind,1.11f);
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
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(ThezLiquids.wind, 3), new DrawRegion("-bottom2"),
                    new DrawRegion("-rotator"){{spinSprite = true; rotateSpeed = -6;}}, new DrawDefault(),
                    new DrawParticles(){{
                        particleRad = 21; particleLife = 190; particleSize = 6;
                        alpha = 0.5f;
                        color = Color.valueOf("FFFFFF");
                    }}
            );
        }};
        stoneGrinder = new WallCrafter("stone-grinder"){{
            requirements(Category.production, ItemStack.with(beryllium, 25));
            size = 2; health = 85; squareSprite = false;

            consume(new ConsumeLiquid(ThezLiquids.wind, 0.05f));
            drillTime = 220;
            output = ThezItems.basaltShard;
            attribute = ThezAttribute.volcanicStone;
            ambientSound = Sounds.drill;
            ambientSoundVolume = 0.08f;
        }};
        rotaryDrill = new Drill("rotary-drill"){{
            requirements(Category.production, ItemStack.with(beryllium, 40));
            size = 3; squareSprite = false;
            tier = 3;
            drillTime = 900;
            liquidBoostIntensity = 1;
            consumeLiquid(ThezLiquids.wind, 0.1f);

            ambientSound = Sounds.grinding;
            ambientSoundVolume = 0.3f;
            alwaysUnlocked = true;
        }};
        circularDrill = new Drill("circular-drill"){{
            requirements(Category.production, ItemStack.with(beryllium, 60, ThezItems.infium, 20f, ThezItems.basaltShard, 15f));
            size = 4;
            tier = 4;
            drillTime = 630;
            liquidBoostIntensity = 1.35f;
            consumeLiquids(LiquidStack.with(ThezLiquids.lava, 0.27f));
            consumePower(0.92f);

            ambientSound = Sounds.grinding;
            ambientSoundVolume = 0.4f;
        }};
    }
}