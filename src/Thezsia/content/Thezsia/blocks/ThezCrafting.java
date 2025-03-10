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

import static arc.math.Interp.*;
import static mindustry.content.Items.*;
import static mindustry.type.ItemStack.with;

public class ThezCrafting{
    public static Block
            //Blocks
            blastFurnace, arcFurnace, infiumMolder, massMolder, gasDecomposer, massiveDecomposer, commonHeater, sulfurHeater, heatRedirector, tensoriteSmelter, tritaniumRefinery, tritaniumSynthesizer;
    public static void load(){
        blastFurnace = new GenericCrafter("blast-furnace"){{
            requirements(Category.crafting, ItemStack.with(beryllium, 50, ThezItems.basaltShard, 15));
            size = 3;
            squareSprite = false;

            consumePower(1);
            consumeItem(ThezItems.basaltShard, 2);
            consumeLiquid(ThezLiquids.wind, 0.23f);
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
            ambientSound = Sounds.machine;
            ambientSoundVolume = 0.08f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(ThezLiquids.lava, 3),
                    new DrawArcSmeltReverse(){{
                        particleLife = 55; particleRad = 9;
                    }}, new DrawDefault(),
                    new DrawGlowRegion(){{
                        color = Color.valueOf("F6916330");
                    }}
            );
        }};
        arcFurnace = new GenericCrafter("arc-furnace"){{
            requirements(Category.crafting, ItemStack.with(beryllium, 80, ThezItems.basaltShard, 32, ThezItems.infium, 50));
            size = 4;
            squareSprite = false;

            consumePower(1.5f);
            consumeItem(ThezItems.basaltShard, 3);
            consumeLiquid(ThezLiquids.wind, 0.34f);
            outputLiquid = new LiquidStack(ThezLiquids.lava,0.3f);

            craftEffect = new RadialEffect(){{rotationSpacing = 45; amount = 4; layer = 118;
                effect = new ParticleEffect(){{
                    particles = 8;
                    length = 14;
                    lifetime = 60;
                    sizeFrom = 2.85f; sizeTo = 0;
                    colorFrom = Color.valueOf("ffffff00"); colorTo = Color.valueOf("ffffff88");
                    layer = 80;
                }};
            }};
            ambientSound = Sounds.machine;
            ambientSoundVolume = 0.1f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(ThezLiquids.lava, 3),
                    new DrawArcSmeltReverse(){{
                        particleLife = 90; particleRad = 13;
                    }}, new DrawDefault(),
                    new DrawGlowRegion(){{
                        color = Color.valueOf("F69163");
                    }}
            );
        }};

        infiumMolder = new GenericCrafter("infium-molder"){{
            requirements(Category.crafting, ItemStack.with(beryllium, 70, ThezItems.basaltShard, 20));
            size = 3;
            squareSprite = false;
            outputItem = new ItemStack(ThezItems.infium, 1);
            consumeItem(ThezItems.silver, 2);
            consumeLiquid(ThezLiquids.lava, 0.2f);
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
            ambientSound = Sounds.machine;
            ambientSoundVolume = 0.08f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(ThezLiquids.lava, 2),
                    new DrawRegion("-rotator"){{
                        spinSprite = true;
                        rotateSpeed = -4;}},
                    new DrawDefault()
            );
        }};
        massMolder = new GenericCrafter("mass-molder"){{
            requirements(Category.crafting, ItemStack.with(beryllium, 100, ThezItems.infium, 75, ThezItems.tensorite, 20));
            size = 4;
            outputItem = new ItemStack(ThezItems.infium, 5);
            consumeLiquid(ThezLiquids.lava, 0.6f); consumeLiquid(ThezLiquids.wind, 0.4f);
            consumePower(1.14f);
            consumeItem(ThezItems.silver, 4);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(ThezLiquids.lava, 2),
                    new DrawParticles(){{
                        particleRad = 10;
                        particleLife = 190;
                        alpha = 0.2f;
                        particleSize = 5;
                        color = Color.valueOf("F69163");
                    }},
                    new DrawRegion("-rotator"){{
                        spinSprite = true;
                        rotateSpeed = -2;
                    }},
                    new DrawCrucibleFlame(){{
                        flameColor = Color.valueOf("C99200FF");
                        midColor = Color.valueOf("A85900");
                        flameRad = 0.1f;
                        circleStroke = 0.2f;
                        alpha = 0.7f;
                        particles = 5;
                    }},
                    new DrawDefault()
            );
            craftEffect = new ParticleEffect(){{
                particles = 8;
                cone = 360;
                sizeFrom = 1.3f;
                sizeTo = 0.1f;
                colorFrom = Color.valueOf("FFCB00FF"); colorTo = Color.valueOf("C99200FF");
                lifetime = 70;
                length = 5;
                baseLength = 5;
            }};
            ambientSound = Sounds.machine;
            ambientSoundVolume = 0.1f;
        }};

        gasDecomposer= new GenericCrafter("gas-decomposer"){{
            requirements(Category.crafting, ItemStack.with(beryllium, 60, ThezItems.basaltShard, 15, ThezItems.infium, 20));
            size = 3;
            squareSprite = false;

            itemCapacity = 0;
            hasLiquids = true;
            liquidCapacity = 40;
            craftTime = 160;
            outputLiquids = LiquidStack.with(ThezLiquids.carbonDioxide,0.22f, ThezLiquids.ammonia,0.1f);
            consumeLiquid(ThezLiquids.wind, 0.38f);
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
                    new DrawLiquidTile(ThezLiquids.wind, 4){{
                        alpha = 0.76f;
                    }}, new DrawDefault(), new DrawLiquidOutputs());
        }};
        massiveDecomposer= new GenericCrafter("massive-decomposer"){{
            requirements(Category.crafting, ItemStack.with(beryllium, 80, ThezItems.silver, 25, ThezItems.infium, 25));
            size = 4;
            squareSprite = false;

            itemCapacity = 0;
            hasLiquids = true;
            liquidCapacity = 70;
            craftTime = 180;
            outputLiquids = LiquidStack.with(ThezLiquids.carbonDioxide,0.72f, ThezLiquids.ammonia,0.45f);
            consumeLiquids(LiquidStack.with(ThezLiquids.wind, 0.64f, ThezLiquids.lava, 0.14f));
            consumePower(2.12f);

            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.12f;
            rotate = true;
            invertFlip = true;
            rotateDraw = false;
            liquidOutputDirections = new int[]{4, 2};
            regionRotated1 = 1;
            outputFacing = true;

            drawer = new DrawMulti(new DrawRegion("-bottom"),
                    new DrawParticles(){{
                        particleRad = 7; particleLife = 135; particleSize = 2.66f;
                        alpha = 0.48f;
                        color = Color.valueOf("cacdd979");
                        reverse = true;
                    }},
                    new DrawLiquidTile(ThezLiquids.wind, 5){{
                        alpha = 0.82f;
                    }}, new DrawDefault(), new DrawLiquidOutputs());
        }};
        commonHeater = new HeatProducer("common-heater"){{
            requirements(Category.crafting, ItemStack.with(beryllium, 20, ThezItems.silver, 80, ThezItems.infium, 30));
            size = 2;
            consumePower(124f / 60f);
            heatOutput = 3;
            warmupRate = 0.165f;
            craftTime = 119;
            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput());
        }};
        sulfurHeater = new HeatProducer("sulfur-heater"){{
            requirements(Category.crafting, ItemStack.with(beryllium, 45, ThezItems.silver, 115, ThezItems.infium, 50, tungsten, 32));
            size = 3;
            consumeItem(ThezItems.sulfur);
            heatOutput = 7;
            warmupRate = 0.165f;
            craftTime = 127;
            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput());
        }};
        heatRedirector = new HeatConductor("heat-redirector"){{
            requirements(Category.crafting, ItemStack.with(ThezItems.basaltShard, 130, ThezItems.silver, 30));
            size = 3;
            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput(), new DrawHeatOutput(), new DrawGlowRegion(){{color = Color.valueOf("876c5c1b");}});
        }};

        tensoriteSmelter = new GenericCrafter("tensorite-smelter"){{
            requirements(Category.crafting, ItemStack.with(beryllium, 80, ThezItems.silver, 10, ThezItems.infium, 40));
            size = 3;
            squareSprite = false;

            itemCapacity = 0;
            hasLiquids = true;
            liquidCapacity = 70;
            craftTime = 180;
            outputLiquids = LiquidStack.with(ThezLiquids.meltedTensorite, 0.217f);
            consumeItem(ThezItems.silver, 3);
            consumeLiquids(LiquidStack.with(ThezLiquids.lava, 0.36f, ThezLiquids.carbonDioxide, 0.14));
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
                    new DrawLiquidTile(ThezLiquids.meltedTensorite,1),
                    new DrawDefault() //DrawRegion(""){{layer = 32f;}}
            );
        }};

        tritaniumRefinery = new HeatCrafter("tritanium-refinery"){{
            requirements(Category.crafting, ItemStack.with(beryllium, 50f, ThezItems.basaltShard, 20f, ThezItems.infium, 30f));
            size = 3;
            outputItem = new ItemStack(ThezItems.tritanium, 1);
            heatRequirement = 12f;
            hasPower = hasItems = true;
            craftTime = 190f;

            consumeItems(with(ThezItems.tritaniumCrystal, 2));
            consumeLiquid(ThezLiquids.ammonia, 0.3f);
            consumePower(1f);

            craftEffect = new MultiEffect(
                    new ParticleEffect(){{
                        particles = 4;
                        length = 19;
                        lifetime = 47;
                        interp = circleOut; sizeInterp = pow5In;
                        lightColor = Color.valueOf("9effd7d2");
                        colorFrom = Color.valueOf("7a7f7be0");
                        colorTo = Color.valueOf("9effd7d2");
                        sizeFrom = 4.7f;
                        sizeTo = 0;
                    }},
                    new ParticleEffect(){{
                        particles = 2;
                        length = 20;
                        lifetime = 64;
                        interp = circleOut; sizeInterp = pow5In;
                        lightColor = Color.valueOf("9effd7d2");
                        colorFrom = Color.valueOf("7a7f7be0");
                        colorTo = Color.valueOf("9effd7d2");
                        sizeFrom = 2.8f;
                        sizeTo = 0;
                    }}
            );
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawRegion("-bottom2"), new DrawHeatInput("-heat"), new DrawDefault(),
                    new DrawGlowRegion(){{
                        color = Color.valueOf("2CDC78");
                    }},
                    new DrawParticles(){{
                        fadeMargin = 1.3f;
                        particleRad = 13;
                        particleLife = 170;
                        alpha = 0.9f;
                        particleSize = 2.4f;
                        color = Color.valueOf("48d986d7");
                    }},
                    new DrawLiquidTile(){{
                        padding = 2;
                        drawLiquid = ThezLiquids.ammonia;
                        alpha = 0.95f;
                    }},
                    new DrawParticles(){{
                        reverse = true;
                        fadeMargin = 0.6f;
                        particleRad = 10;
                        particleLife = 125;
                        alpha = 0.45f;
                        particleSize = 1.4f;
                        color = Color.valueOf( "4fff959e");
                    }}
            );
            ambientSound = Sounds.machine;
            ambientSoundVolume = 0.06f;
        }};
        tritaniumSynthesizer = new HeatCrafter("tritanium-synthesizer"){{
            requirements(Category.crafting, ItemStack.with(beryllium, 90f, ThezItems.infium, 60f, ThezItems.tensorite, 30f, ThezItems.sulfur, 15f));
            size = 4;
            outputItem = new ItemStack(ThezItems.tritanium, 4);
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
                        colorFrom = Color.valueOf("7a7f7be0");
                        colorTo = Color.valueOf("9effd7d2");
                        sizeFrom = 4.8f;
                        sizeTo = 0;
                    }},
                    new ParticleEffect(){{
                        particles = 2;
                        length = 25;
                        lifetime = 72;
                        interp = circleOut; sizeInterp = pow5In;
                        lightColor = Color.valueOf("9effd7d2");
                        colorFrom = Color.valueOf("7a7f7be0");
                        colorTo = Color.valueOf("9effd7d2");
                        sizeFrom = 2.9f;
                        sizeTo = 0;
                    }}
            );
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawRegion("-bottom2"), new DrawHeatInput("-heat"), new DrawDefault(),
                    new DrawGlowRegion(){{
                        color = Color.valueOf("2CDC78");
                    }},
                    new DrawParticles(){{
                        fadeMargin = 1.4f;
                        particleRad = 14;
                        particleLife = 176;
                        alpha = 0.9f;
                        particleSize = 2.5f;
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
                        particleRad = 12;
                        particleLife = 137;
                        alpha = 0.45f;
                        particleSize = 1.55f;
                        color = Color.valueOf( "4fff959e");
                    }}
            );
            ambientSound = Sounds.machine;
            ambientSoundVolume = 0.09f;

            consumeItems(with(ThezItems.tritaniumCrystal, 5));
            consumeLiquid(ThezLiquids.ammonia, 0.45f);
            consumePower(2.5f);
        }};
    }
}