package Thezsia.content.Thezsia.blocks;

import Thezsia.content.ThezItems;
import arc.graphics.Color;
import mindustry.entities.effect.ParticleEffect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.ForceProjector;
import mindustry.world.blocks.defense.RegenProjector;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawParticles;
import mindustry.world.draw.DrawRegion;

import static arc.math.Interp.pow2;
import static arc.math.Interp.pow2Out;
import static mindustry.content.Items.beryllium;

public class ThezDefence{
    public static Block
            //walls
            basaltWall, largeBasaltWall, infiumWall, largeInfiumWall, tensoriteWall, largeTensoriteWall, tritaniumWall, largeTritaniumWall, crackedWall, largeCrackedWall,
            //effects
            renewer, barrierProjector;
    public static void load(){
        //walls
        basaltWall = new Wall("basalt-wall"){{
            requirements(Category.defense, ItemStack.with(ThezItems.basaltShard, 6));
            size = 1; health = 360;
        }};
        largeBasaltWall = new Wall("large-basalt-wall"){{
            requirements(Category.defense, ItemStack.with(ThezItems.basaltShard, 24));
            size = 2; health = 1440;
        }};
        infiumWall = new Wall("infium-wall"){{
            requirements(Category.defense, ItemStack.with(ThezItems.infium, 6));
            size = 1; health = 440;
        }};
        largeInfiumWall = new Wall("large-infium-wall"){{
            requirements(Category.defense, ItemStack.with(ThezItems.infium, 24));
            size = 2; health = 1760;
        }};
        tensoriteWall = new Wall("tensorite-wall"){{
            requirements(Category.defense, ItemStack.with(ThezItems.tensorite, 6));
            size = 1; health = 560;
        }};
        largeTensoriteWall = new Wall("large-tensorite-wall"){{
            requirements(Category.defense, ItemStack.with(ThezItems.tensorite, 24));
            size = 2; health = 2240;
        }};
        tritaniumWall = new RegenProjector("tritanium-wall"){{
            requirements(Category.defense, ItemStack.with(ThezItems.tritanium, 6, ThezItems.sulfur, 4));
            health = 410; size = 1;
            baseColor = Color.valueOf("2CDC78FF");
            range = 1; healPercent = 0.005f;
            effect = new ParticleEffect(){{
                colorFrom = Color.valueOf("2FA157FF"); colorTo = Color.valueOf("307046FF");
                particles = 3;
                line = false;
                strokeFrom = 0.7f; strokeTo = 1.8f;
                lifetime = 80;
                cone = 360;
                interp = pow2; sizeInterp = pow2Out;
            }};
            drawer = new DrawMulti(
                    new DrawDefault()
            );
        }};
        largeTritaniumWall = new RegenProjector("large-tritanium-wall"){{
            requirements(Category.defense, ItemStack.with(ThezItems.tritanium, 24, ThezItems.sulfur, 16));
            health = 1640; size = 2;
            baseColor = Color.valueOf("2CDC78FF");
            range = 2; healPercent = 0.005f;
            effect = new ParticleEffect(){{
                colorFrom = Color.valueOf("2FA157FF"); colorTo = Color.valueOf("307046FF");
                particles = 3;
                line = false;
                strokeFrom = 0.7f; strokeTo = 1.8f;
                lifetime = 80;
                cone = 360;
                interp = pow2; sizeInterp = pow2Out;
            }};
            drawer = new DrawMulti(
                    new DrawDefault()
            );
        }};
        crackedWall = new Wall("cracked-wall"){{
            requirements(Category.defense, ItemStack.with(ThezItems.silver, 4));
            health = 165; size = 1; variants = 3;
        }};
        largeCrackedWall = new Wall("large-cracked-wall"){{
            requirements(Category.defense, ItemStack.with(ThezItems.silver, 19));
            health = 471; size = 2; variants = 3;
        }};
        //effects
        renewer = new RegenProjector("renewer"){{
            requirements(Category.effect, ItemStack.with(beryllium, 40, ThezItems.tensorite, 30, ThezItems.tritaniumCrystal, 15));
            health = 185; size = 2; squareSprite = false;

            baseColor = Color.valueOf("2CDC78FF");
            range = 14; healPercent = 0.013f;

            consumePower(1.87f);
            consumeItem(ThezItems.tritanium).boost();
            effect = new ParticleEffect(){{
                colorFrom = Color.valueOf("2FA157FF"); colorTo = Color.valueOf("307046FF");
                particles = 4;
                line = false;
                strokeFrom = 0.6f; strokeTo = 1.9f;
                lifetime = 85;
                cone = 360;
                interp = pow2; sizeInterp = pow2Out;
            }};

            drawer = new DrawMulti(new DrawRegion("-bottom"),
                    new DrawParticles(){{
                        particleRad = 5; particleLife = 120; particleSize = 3;
                        alpha = 0.5f;
                        color = Color.valueOf("2CDC78");
                        reverse = true;
                    }}, new DrawDefault());
        }};
        barrierProjector = new ForceProjector("barrier-projector"){{
            requirements(Category.effect, ItemStack.with(beryllium, 80, ThezItems.tensorite, 50, ThezItems.sulfur, 15, ThezItems.tritaniumCrystal, 25));
            size = 3;
            squareSprite = false;

            consumePower(2.185f);
            //consumeItem(ThezItems.tritanium).boost();
            itemConsumer = consumeItem(ThezItems.tritanium).boost();

            cooldownNormal = 2.65f;
            cooldownLiquid = 2.5f;
            cooldownBrokenBase = 1.15f;
            coolantConsumption = 0.2f;

            radius = 128;
            phaseRadiusBoost = 96;
            phaseShieldBoost = 200;
            phaseUseTime = 190;

            shieldHealth = 1200;
            shieldRotation = 0;
            sides = 4; //4, 12
            solid = true;
            canOverdrive = true;
        }};
    }
}