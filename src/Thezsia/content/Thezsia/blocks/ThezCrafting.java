package Thezsia.content.Thezsia.blocks;

import Thezsia.content.ThezItems;
import Thezsia.content.ThezLiquids;
import Thezsia.world.draw.DrawArcSmeltReverse;
import arc.graphics.Color;
import mindustry.entities.effect.*;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;

import static Thezsia.content.ThezItems.*;
import static Thezsia.content.ThezLiquids.*;
import static arc.math.Interp.*;
import static mindustry.type.ItemStack.with;

public class ThezCrafting{
    public static Block
            //Blocks
            blastFurnace, arcFurnace, infiumMolder, massMolder, gasDecomposer, massiveDecomposer, commonHeater, sulfurHeater, heatRedirector, tensoriteSmelter, tritaniumRefinery, tritaniumSynthesizer;
    public static void load(){
        blastFurnace = new GenericCrafter("blast-furnace"){{
            requirements(Category.crafting, ItemStack.with(tantalum, 50, nihilite, 15));
            size = 3;
            squareSprite = false;

            consumePower(1);
            consumeItem(nihilite, 2);
            consumeLiquid(wind, 0.23f);
            outputLiquid = new LiquidStack(ThezLiquids.lava,0.126666f);

            craftEffect = new RadialEffect(){{rotationSpacing = 45; amount = 2; layer = 118;
                effect = new ParticleEffect(){{
                    particles = 4;
                    length = 14;
                    lifetime = 60;
                    sizeFrom = 2.5f; sizeTo = 0;
                    colorFrom = Color.valueOf("ffffff00"); colorTo = Color.valueOf("ffffff88");
                    layer = 80;
                }};
            }};
            ambientSound = Sounds.machine; ambientSoundVolume = 0.08f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(ThezLiquids.lava, 3),
                    new DrawArcSmeltReverse(){{
                        particleLife = 55; particleRad = 9;
                    }}, new DrawDefault(),
                    new DrawGlowRegion(){{
                        color = Color.valueOf("F6916330");
                    }}
            );
        }};

        infiumMolder = new GenericCrafter("infium-molder"){{
            requirements(Category.crafting, ItemStack.with(tantalum, 70, nihilite, 20));
            size = 3;
            squareSprite = false;
            outputItem = new ItemStack(infium, 1);
            consumeItem(silver, 2);
            consumeLiquid(lava, 0.2f);
            consumePower(0.87f);
            craftEffect = new ParticleEffect(){{
                particles = 6;
                cone = 360;
                sizeFrom = 1;
                sizeTo = 0.1f;
                colorFrom = Color.valueOf("FFCB00FF");
                colorTo = Color.valueOf("C99200FF");
                lifetime = 60;
                length = 3;
                baseLength = 5;
            }};
            ambientSound = Sounds.machine; ambientSoundVolume = 0.08f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(lava, 2),
                    new DrawRegion("-rotator"){{
                        spinSprite = true;
                        rotateSpeed = -4;}},
                    new DrawDefault()
            );
        }};

        gasDecomposer= new GenericCrafter("gas-decomposer"){{
            requirements(Category.crafting, ItemStack.with(tantalum, 60, nihilite, 15, infium, 20));
            size = 3;
            squareSprite = false;

            itemCapacity = 0;
            hasLiquids = true;
            liquidCapacity = 40;
            craftTime = 160;
            outputLiquids = LiquidStack.with(carbonDioxide,0.22f, ammonia,0.1f);
            consumeLiquid(wind, 0.38f);
            consumePower(1.2f);

            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.08f;
            rotate = true;
            invertFlip = true;
            rotateDraw = false;
            liquidOutputDirections = new int[]{4, 2};
            regionRotated1 = 1;
            outputFacing = true;

            drawer = new DrawMulti(new DrawRegion("-bottom"),
                    new DrawParticles(){{
                        particleRad = 6; particleLife = 120; particleSize = 2.5f;
                        alpha = 0.42f;
                        color = Color.valueOf("cacdd979");
                        reverse = true;
                    }},
                    new DrawLiquidTile(wind, 4){{
                        alpha = 0.76f;
                    }}, new DrawDefault(), new DrawLiquidOutputs());
        }};

        commonHeater = new HeatProducer("common-heater"){{
            requirements(Category.crafting, ItemStack.with(tantalum, 20, silver, 80, infium, 30));
            size = 2;
            consumePower(124f / 60f);
            heatOutput = 3;
            warmupRate = 0.165f;
            craftTime = 119;
            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput());
        }};
        sulfurHeater = new HeatProducer("sulfur-heater"){{
            requirements(Category.crafting, ItemStack.with(tantalum, 45, silver, 115, infium, 50));
            size = 3;
            consumeItem(sulfur);
            heatOutput = 7;
            warmupRate = 0.165f;
            craftTime = 127;
            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput());
        }};
        heatRedirector = new HeatConductor("heat-redirector"){{
            requirements(Category.crafting, ItemStack.with(nihilite, 130, silver, 30));
            size = 3;
            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput(), new DrawHeatOutput(), new DrawGlowRegion(){{color = Color.valueOf("876c5c1b");}});
        }};

        tensoriteSmelter = new GenericCrafter("tensorite-smelter"){{
            requirements(Category.crafting, ItemStack.with(tantalum, 80, silver, 10, infium, 40));
            size = 3;
            squareSprite = false;

            itemCapacity = 0;
            hasLiquids = true;
            liquidCapacity = 70;
            craftTime = 180;
            outputLiquids = LiquidStack.with(meltedTensorite, 0.217f);
            consumeItem(ThezItems.silver, 3);
            consumeLiquids(LiquidStack.with(lava, 0.36f, carbonDioxide, 0.14));
            consumePower(2.12f);

            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.10f;
            rotate = false;
            invertFlip = true;
            rotateDraw = false;
            liquidOutputDirections = new int[]{2};
            regionRotated1 = 1;
            outputFacing = true;

            drawer = new DrawMulti(
                    //new DrawRegion("-hintoverlay"){{layer = 29.5f;}},
                    new DrawRegion("-bottom"), //{{layer = 30.1f;}},
                    new DrawRegion("-top"){{layer = 30.5f;}},
                    new DrawLiquidTile(meltedTensorite,1),
                    new DrawDefault() //DrawRegion(""){{layer = 32f;}}
            );
        }};

        tritaniumSynthesizer = new HeatCrafter("tritanium-synthesizer"){{
            requirements(Category.crafting, ItemStack.with(tantalum, 90f, infium, 60f, tensorite, 30f, sulfur, 15f));
            size = 4;
            outputItem = new ItemStack(tritanium, 4);
            heatRequirement = 18f;
            hasPower = hasItems = true;
            craftTime = 235f;
            squareSprite = false;
            craftEffect = new MultiEffect(
                    new ParticleEffect(){{
                        particles = 5;
                        length = 22;
                        lifetime = 52;
                        interp = circleOut; sizeInterp = pow5In;
                        lightColor = Color.valueOf("9effd7d2");
                        colorFrom = Color.valueOf("7a7f7be0"); colorTo = Color.valueOf("9effd7d2");
                        sizeFrom = 4.8f; sizeTo = 0;
                    }},
                    new ParticleEffect(){{
                        particles = 2;
                        length = 25;
                        lifetime = 72;
                        interp = circleOut; sizeInterp = pow5In;
                        lightColor = Color.valueOf("9effd7d2");
                        colorFrom = Color.valueOf("7a7f7be0"); colorTo = Color.valueOf("9effd7d2");
                        sizeFrom = 2.9f; sizeTo = 0;
                    }}
            );
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawRegion("-bottom2"), new DrawHeatInput("-heat"), new DrawDefault(),
                    new DrawGlowRegion(){{color = Color.valueOf("2CDC78");}},
                    new DrawParticles(){{
                        fadeMargin = 1.4f;
                        particleRad = 14; particleLife = 176; particleSize = 2.5f;
                        alpha = 0.9f;
                        color = Color.valueOf("48d986d7");
                    }},
                    new DrawLiquidTile(){{
                        padding = 2;
                        drawLiquid = ThezLiquids.ammonia;
                        alpha = 0.95f;
                    }},
                    new DrawParticles(){{
                        reverse = true;
                        fadeMargin = 0.7f;
                        particleRad = 12; particleLife = 137; particleSize = 1.55f;
                        alpha = 0.45f;
                        color = Color.valueOf( "4fff959e");
                    }}
            );
            ambientSound = Sounds.machine; ambientSoundVolume = 0.09f;

            consumeItems(with(tritaniumCrystal, 5));
            consumeLiquid(ammonia, 0.45f);
            consumePower(2.5f);
        }};
    }
}