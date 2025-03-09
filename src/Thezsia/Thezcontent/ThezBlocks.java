package Thezsia.Thezcontent;

import Thezsia.Thezworld.blocks.ThezAttribute;
import Thezsia.Thezworld.blocks.distribution.ClosedConveyor;
import Thezsia.Thezworld.blocks.environment.BiggerVent;
import Thezsia.Thezworld.blocks.power.PowerWire;
import Thezsia.Thezworld.blocks.power.TransferPowerConsumeGenerator;
import Thezsia.Thezworld.blocks.storage.GeneratorCore;
import Thezsia.Thezworld.draw.*;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.gen.*;
import mindustry.type.Category;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.HeatConductor;
import mindustry.world.blocks.heat.HeatProducer;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.Attribute;

import static arc.graphics.Blending.additive;
import static arc.math.Interp.*;
import static mindustry.content.Items.*;
import static mindustry.logic.LAccess.team;
import static mindustry.type.ItemStack.with;

public class ThezBlocks {
    public static Block
            //environment
            basalticPatch, basalticRock, basalticWall,
            charrokFloor, hardCharrok, charrokPile, hardCharrokPile, charrokWall, hardCharrokWall, largeCharrokPile, largeHardCharrokPile,
            limestone, limestoneDark, limestoneCracked, limestoneBoulder, limestoneDarkBoulder, limestoneWall, limestoneDarkWall, limestoneCrackWall,
            smoothSulfur, sulfurFloor, sulfurVent, sulfurBigVent, sulfurBoulder, sulfurWall, largeSulfurPile,
            peridotite, peridotiteDark, peridotiteCube, peridotiteDarkCube, peridotiteWall, peridotiteDarkWall, tritaniumCluster,
            //ores
            basalticVein, silverLick, tritaniumOre, tritaniumOreWall,

            //crafting
            blastFurnace, arcFurnace, infiumMolder, massMolder, gasDecomposer, massiveDecomposer, commonHeater, sulfurHeater, heatRedirector, tensoriteSmelter, tensoriteSynthesizer, tritaniumRefinery, tritaniumSynthesizer,

            //production (drills,extractors, "cultivators")
            windTrap, largeWindTrap, stoneGrinder, rotaryDrill, circularDrill,

            //effects
            renewer, barrierProjector,

            //walls
            basaltWall, largeBasaltWall, infiumWall, largeInfiumWall, tensoriteWall, largeTensoriteWall, tritaniumWall, largeTritaniumWall, crackedWall, largeCrackedWall,

            //distribution
            berylliumBelt, berylliumConvJunction, berylliumConvRouter, berylliumConvBridge, berylliumConvSorter, invertedBerylliumConvSorter, berylliumConvSpillwayGate, invertedBerylliumConvSpillwayGate,

            //liquid
            berylliumPipe, infiumPipe, liquidJunction, liquidHub, liquidBallast, liquidBridge,

            //power
            silverCable, capacitor, lavaGenerator, testFignya,

            //storage (cores)
            coreDust, coreFog,

            //turrets
            ember, gaze,

            //units (blocks)
            groundFabricator,

            //payloads
            massConveyor, massRouter

            //logic
            

            //sandbox


            //campaign
            ;
    public static void load() {
        {
            {
                //environement
                /*
                testBiggerVent = new BiggerVent("test-bigger-vent"){{
                    variants = 2;
                    blendGroup = parent = stone;
                    attributes.set(Attribute.steam, 1f);
                }};
                */
                basalticPatch = new Floor("basaltic-patch"){{
                    variants = 3;
                }};
                basalticRock = new Prop("basaltic-rock"){{
                    variants = 2;
                }};
                basalticWall = new StaticWall("basaltic-wall"){{
                    variants = 2;
                    basalticPatch.asFloor().wall = this;
                    attributes.set(ThezAttribute.volcanicStone, 0.8f);
                }};
                charrokFloor = new Floor("charrok-floor"){{
                    variants = 2;
                }};
                hardCharrok = new Floor("hard-charrok"){{
                    variants = 2;
                }};
                charrokPile = new Prop("charrok-pile"){{
                    variants = 2;
                    charrokFloor.asFloor().decoration = this;
                }};
                hardCharrokPile = new Prop("hard-charrok-pile"){{
                    variants = 2;
                    hardCharrok.asFloor().decoration = this;
                }};
                charrokWall = new StaticWall("charrok-wall"){{
                    variants = 2;
                    charrokFloor.asFloor().wall = this;
                }};
                hardCharrokWall = new StaticWall("hard-charrok-wall"){{
                    variants = 2;
                    hardCharrok.asFloor().wall = this;
                }};
                largeCharrokPile = new TallBlock("large-charrok-pile"){{
                    variants = 2;
                    shadowAlpha = 0.3f;
                }};
                largeHardCharrokPile = new TallBlock("large-hard-charrok-pile"){{
                    variants = 2;
                    shadowAlpha = 0.3f;
                }};
                limestone = new Floor("limestone"){{
                    variants = 2;
                }};
                limestoneDark = new Floor("limestone-dark"){{
                    variants = 2;
                }};
                limestoneCracked = new Floor("limestone-cracked"){{
                    variants = 2;
                }};
                limestoneBoulder = new Prop("limestone-boulder"){{
                    variants = 2;
                    limestone.asFloor().decoration = this;
                }};
                limestoneDarkBoulder = new Prop("limestone-dark-boulder"){{
                    variants = 2;
                    limestoneDark.asFloor().decoration = this;
                }};
                limestoneWall = new StaticWall("limestone-wall"){{
                    variants = 2;
                    limestone.asFloor().wall = this;
                }};
                limestoneDarkWall = new StaticWall("limestone-dark-wall"){{
                    variants = 2;
                    limestoneDark.asFloor().wall = this;
                }};
                limestoneCrackWall = new StaticWall("limestone-crack-wall"){{
                    variants = 2;
                    limestoneCracked.asFloor().wall = this;
                }};
                smoothSulfur = new Floor("smooth-sulfur"){{
                    variants = 4;
                }};
                sulfurFloor = new Floor("sulfur-floor"){{
                    variants = 4;
                    blendGroup = ThezBlocks.smoothSulfur;
                }};
                sulfurVent = new SteamVent("sulfur-vent"){{
                    variants = 0;
                    blendGroup = parent = sulfurFloor = smoothSulfur;
                    attributes.set(Attribute.steam, 1f);
                }};
                sulfurBigVent = new BiggerVent("sulfur-big-vent"){{
                    variants = 0;
                    blendGroup = parent = sulfurFloor;
                    attributes.set(Attribute.steam, 1.6f);
                }};
                sulfurBoulder = new Prop("sulfur-boulder"){{
                    variants = 2;
                    sulfurFloor.asFloor().decoration = smoothSulfur.asFloor().decoration = this;
                }};
                sulfurWall = new StaticWall("sulfur-wall"){{
                    variants = 2;
                    sulfurFloor.asFloor().wall = smoothSulfur.asFloor().wall = this;
                }};
                largeSulfurPile = new TallBlock("large-sulfur-pile"){{
                    variants = 1;
                    shadowAlpha = 0.3f;
                }};
                peridotite = new Floor("peridotite"){{
                    variants = 4;
                }};
                peridotiteDark = new Floor("peridotite-dark"){{
                    variants = 4;
                }};
                peridotiteCube = new Prop("peridotite-cube"){{
                    variants = 2;
                    peridotite.asFloor().decoration = this;
                }};
                peridotiteDarkCube = new Prop("peridotite-dark-cube"){{
                    variants = 2;
                    peridotiteDark.asFloor().decoration = this;
                }};
                peridotiteWall = new StaticWall("peridotite-wall"){{
                    variants = 2;
                    peridotite.asFloor().wall = this;
                }};
                peridotiteDarkWall = new StaticWall("peridotite-dark-wall"){{
                    variants = 2;
                    peridotiteDark.asFloor().wall = this;
                }};
                tritaniumCluster = new TallBlock("tritanium-cluster"){{
                    variants = 2;
                    shadowAlpha = 0.3f;
                }};
                //ores
                basalticVein = new OreBlock("basaltic-vein"){{
                    variants = 3;
                    itemDrop = ThezItems.basaltShard;
                    wallOre = false;
                }};
                silverLick = new OreBlock("silver-lick"){{
                    variants = 3;
                    itemDrop = ThezItems.silver;
                    wallOre = false;
                }};
                tritaniumOre = new OreBlock("tritanium-ore"){{
                    variants = 3;
                    itemDrop = ThezItems.tritaniumCrystal;
                    wallOre = false;
                }};
                tritaniumOreWall = new OreBlock("tritanium-wallore"){{
                    variants = 3;
                    itemDrop = ThezItems.tritaniumCrystal;
                    wallOre = true;
                }};
                //crafting
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

                //production (drills,extractors, "cultivators")
                windTrap = new GenericCrafter("wind-trap"){{
                    requirements(Category.production, ItemStack.with(beryllium, 100));
                    size = 4;
                    health = 320;
                    squareSprite = false;
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
                    size = 5;
                    health = 525;
                    squareSprite = false;

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
                    size = 2;
                    health = 85;
                    squareSprite = false;

                    consume(new ConsumeLiquid(ThezLiquids.wind, 0.05f));
                    drillTime = 220;
                    output = ThezItems.basaltShard;
                    attribute = ThezAttribute.volcanicStone;
                    ambientSound = Sounds.drill;
                    ambientSoundVolume = 0.08f;
                }};
                rotaryDrill = new Drill("rotary-drill"){{
                    requirements(Category.production, ItemStack.with(beryllium, 40));
                    consumeLiquid(ThezLiquids.wind, 0.1f);
                    squareSprite = false;
                    size = 3;
                    tier = 3;
                    drillTime = 900;
                    liquidBoostIntensity = 1;

                    ambientSound = Sounds.grinding;
                    ambientSoundVolume = 0.3f;
                    alwaysUnlocked = true;
                }};
                circularDrill = new Drill("circular-drill"){{
                    requirements(Category.production, ItemStack.with(beryllium, 60, ThezItems.infium, 20f, ThezItems.basaltShard, 15f));
                    size = 4;
                    tier = 4;
                    //accelTime = (int) 75f;
                    //accelLimit = 175;
                    drillTime = 630;
                    //drillAccelMultiplier = 2
                    liquidBoostIntensity = 1.35f;
                    consumeLiquids(LiquidStack.with(ThezLiquids.lava, 0.27f));
                    consumePower(0.92f);
                    //powerRequirement = 1f;

                    ambientSound = Sounds.grinding;
                    ambientSoundVolume = 0.4f;
                }};

               //effects
               renewer = new RegenProjector("renewer"){{
                    requirements(Category.effect, ItemStack.with(beryllium, 40, ThezItems.tensorite, 30, ThezItems.tritaniumCrystal, 15));
                    health = 185;
                    size = 2;
                    squareSprite = false;

                    baseColor = Color.valueOf("2CDC78FF");
                    range = 14;
                    healPercent = 0.013f;

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

               //walls
                basaltWall = new Wall("basalt-wall"){{
                    requirements(Category.defense, ItemStack.with(ThezItems.basaltShard, 6));
                    health = 360;
                    size = 1;
                }};
                largeBasaltWall = new Wall("large-basalt-wall"){{
                    requirements(Category.defense, ItemStack.with(ThezItems.basaltShard, 24));
                    health = 1440;
                    size = 2;
                }};
               infiumWall = new Wall("infium-wall"){{
                    requirements(Category.defense, ItemStack.with(ThezItems.infium, 6));
                    health = 440;
                    size = 1;
               }};
               largeInfiumWall = new Wall("large-infium-wall"){{
                    requirements(Category.defense, ItemStack.with(ThezItems.infium, 24));
                    health = 1760;
                    size = 2;
               }};
               tensoriteWall = new Wall("tensorite-wall"){{
                    requirements(Category.defense, ItemStack.with(ThezItems.tensorite, 6));
                    health = 560;
                    size = 1;
               }};
               largeTensoriteWall = new Wall("large-tensorite-wall"){{
                    requirements(Category.defense, ItemStack.with(ThezItems.tensorite, 24));
                    health = 2240;
                    size = 2;
               }};
               tritaniumWall = new RegenProjector("tritanium-wall"){{
                    requirements(Category.defense, ItemStack.with(ThezItems.tritanium, 6, ThezItems.sulfur, 4));
                    health = 410;
                    size = 1;
                    baseColor = Color.valueOf("2CDC78FF");
                    range = 1;
                    healPercent = 0.005f;
                    effect = new ParticleEffect(){{
                        colorFrom = Color.valueOf("2FA157FF"); colorTo = Color.valueOf("307046FF");
                        particles = 3;
                        line = false;
                        strokeFrom = 0.7f;
                        strokeTo = 1.8f;
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
                    health = 1640;
                    size = 2;
                    baseColor = Color.valueOf("2CDC78FF");
                    range = 2;
                    healPercent = 0.005f;
                    effect = new ParticleEffect(){{
                        colorFrom = Color.valueOf("2FA157FF"); colorTo = Color.valueOf("307046FF");
                        particles = 3;
                        line = false;
                        strokeFrom = 0.7f;
                        strokeTo = 1.8f;
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
                    health = 165;
                    size = 1;
                    variants = 3;
                }};
                largeCrackedWall = new Wall("large-cracked-wall"){{
                    requirements(Category.defense, ItemStack.with(ThezItems.silver, 19));
                    health = 471;
                    size = 2;
                    variants = 3;
                }};

               //distribution
               berylliumBelt = new ClosedConveyor("beryllium-belt"){{
                    requirements(Category.distribution, ItemStack.with(beryllium, 1));
                    health = 40;
                    speed = 0.04f;
                    displayedSpeed = 5.4f;

                    bridgeReplacement = ThezBlocks.berylliumConvBridge;
                    junctionReplacement = ThezBlocks.berylliumConvJunction;
               }};
               berylliumConvJunction = new Junction("beryllium-conv-junction"){{
                    requirements(Category.distribution, ItemStack.with(beryllium, 3));
                    size = 1;

                    speed = 35;
                    capacity = 6;
               }};
                berylliumConvBridge = new ItemBridge("beryllium-conv-bridge"){{
                    requirements(Category.distribution, ItemStack.with(beryllium, 8));
                    size = 1;
                    health = 80;

                    hasPower = false;
                    range = 3;
               }};
               ((ClosedConveyor) berylliumBelt).junctionReplacement = berylliumConvJunction;
                berylliumConvRouter = new Router("beryllium-conv-router"){{
                    requirements(Category.distribution, ItemStack.with(beryllium, 5));
                    size = 1;
               }};
               ((ClosedConveyor) berylliumBelt).bridgeReplacement = berylliumConvBridge;
               berylliumConvSorter = new Sorter("beryllium-conv-sorter"){{
                    requirements(Category.distribution, ItemStack.with(beryllium, 5, ThezItems.basaltShard,2));
                    health =50;
               }};
               invertedBerylliumConvSorter = new Sorter("inverted-beryllium-conv-sorter"){{
                    requirements(Category.distribution, ItemStack.with(beryllium, 5, ThezItems.basaltShard,2));
                    health = 50;
                    invert = true;
               }};
                berylliumConvSpillwayGate = new OverflowGate("beryllium-conv-spillway-gate"){{
                    requirements(Category.distribution, ItemStack.with(beryllium, 5, ThezItems.basaltShard,2));
                    health = 50;
                    researchCostMultiplier = 0.5f;
               }};
               invertedBerylliumConvSpillwayGate = new OverflowGate("inverted-beryllium-conv-spillway-gate"){{
                    requirements(Category.distribution, ItemStack.with(beryllium, 5, ThezItems.basaltShard,2));
                    health = 50;
                    invert = true;
                    researchCostMultiplier = 0.5f;
               }};

               //liquid
               berylliumPipe = new Conduit("beryllium-pipe"){{
                    requirements(Category.liquid, ItemStack.with(beryllium, 2));
                    size = 1;
                    liquidCapacity = 12;
                    botColor = Color.valueOf("19181AFF");
               }};
               infiumPipe = new Conduit("infium-pipe"){{
                    requirements(Category.liquid, ItemStack.with(ThezItems.infium, 2, ThezItems.sulfur, 1));
                    health = 160;
                    size = 1;
                    liquidCapacity = 25;
                    botColor = Color.valueOf("19181AFF");
               }};
               liquidJunction = new LiquidJunction("liquid-junction"){{
                    requirements(Category.liquid,ItemStack.with(beryllium, 6));
                    health = 50;
                    size = 1;
               }};
               ((Conduit) berylliumPipe).junctionReplacement = liquidJunction;
               ((Conduit) infiumPipe).junctionReplacement = liquidJunction;
               liquidBridge = new LiquidBridge("liquid-bridge"){{
                    requirements(Category.liquid, ItemStack.with(beryllium, 10));
                    size = 1;
                    hasPower = false;
                    range = 3;
                    arrowSpacing =5;
               }};
               ((Conduit) berylliumPipe).bridgeReplacement = liquidBridge;
               ((Conduit) infiumPipe).bridgeReplacement = liquidBridge;
               liquidHub = new LiquidRouter("liquid-hub"){{
                    requirements(Category.liquid, ItemStack.with(beryllium, 5));
                    health = 45;
                    size = 1;
                    liquidPadding = 1;
               }};
               liquidBallast = new LiquidRouter("liquid-ballast"){{
                    requirements(Category.liquid, ItemStack.with(beryllium, 40, ThezItems.infium, 10));
                    size = 2;
                    liquidPadding = 2;
                    squareSprite = false;
               }};


               //power
                silverCable = new PowerWire("silver-cable"){{
                    requirements(Category.power, with(beryllium, 1, ThezItems.silver, 1));
                    health = 12;
                }};
                testFignya = new TransferPowerConsumeGenerator("test-fignya"){{
                    requirements(Category.power, with(beryllium, 1, ThezItems.silver, 1));
                    size = 2;
                    health = 12;
                    radius = 240f;
                }};


               //storage (cores)
               coreDust = new GeneratorCore("core-dust"){{
                    requirements(Category.effect, ItemStack.with(beryllium, 750, ThezItems.silver, 70));
                    size= 4;
                    health = 1950;
                    squareSprite = false;

                    hasPower = true;
                    conductivePower = true;
                    powerProduction = 180 / 60f;
                    consumePowerBuffered(180);

                    //glowColors = new Color[]{Color.valueOf("ade7ec79")};
                    //glowMag = 0.78f; glowScl = 9.5f;

                    itemCapacity = 5000;
                    unitType = ThezUnitTypes.Iambient;
                    unitCapModifier = 10;

                    isFirstTier = true;
                    alwaysUnlocked = true;
               }};
               coreFog = new GeneratorCore("core-fog"){{
                    requirements(Category.effect, ItemStack.with(beryllium, 1200, ThezItems.silver, 500, ThezItems.infium, 260, ThezItems.tensorite, 180));
                    size= 5;
                    health = 3700;
                    squareSprite = false;

                    hasPower = true;
                    conductivePower = true;
                    powerProduction = 600 / 60f;
                    consumePowerBuffered(100);

                    //glowColors = new Color[]{Color.valueOf("ade7ec79")};
                    //glowMag = 0.78f; glowScl = 9.5f;

                    itemCapacity = 7500;
                    unitType = ThezUnitTypes.IIambient;
                    unitCapModifier = 15;
               }};

               //turrets
               ember = new ItemTurret("ember"){{
                    requirements(Category.turret, ItemStack.with(beryllium, 50));
                    size = 3;
                    squareSprite = false;
                    coolant = consume(new ConsumeCoolant(0.1f, true, true));
                    rotateSpeed = 3.1f;
                    outlineColor = Color.valueOf("19181AFF");
                    targetAir = false;
                    targetGround = true;
                    reload = 82f;
                    range = 200f;
                    fogRadiusMultiplier = 0.5f;
                    inaccuracy = 2;
                    shootY = 2;
                    shootSound = Sounds.largeCannon;
                    cooldownTime = 90f;
                    ammoPerShot = 5;
                    minWarmup = 0.5f;
                    shootWarmupSpeed = 0.03f;
                    ammo(
                            ThezItems.basaltShard, new BasicBulletType(){{
                                ammoMultiplier = 2;
                                shootEffect = Fx.shootTitan;
                                smokeEffect = Fx.shootSmokeTitan;
                                width = 8;
                                height = 10;
                                //sprite = "thezsia-berylliumic-fragment";
                                speed = 5.5f;
                                lifetime = 36.36f;
                                pierce = true;
                                damage = 10;
                                pierceCap = 3;
                                pierceBuilding = true;
                                trailLength = 8;
                                trailWidth = 2;
                            }},
                            beryllium, new BasicBulletType(){{
                                ammoMultiplier = 1;
                                shootEffect = Fx.shootTitan;
                                smokeEffect = Fx.shootSmokeTitan;
                                width = 9.4f;
                                height = 13.4f;
                                //sprite = "thezsia-volcanic-stone-fragment";
                                speed = 5.7f;
                                lifetime = 38.59f;
                                damage = 13;
                                rangeChange = 20;
                                pierceCap = 4;
                                pierceBuilding = true;
                                trailLength = 9;
                                trailWidth = 2.3f;
                                fragRandomSpread = 7;
                                fragOnHit = true;
                                fragSpread = 30;
                                fragBullets = 5;
                                fragBullet = new BasicBulletType(){{
                                   width = 4.5f;
                                   height = 7.5f;
                                   lifetime = 28;
                                   speed = 3.25f;
                                   damage = 3;
                                   pierceCap = 2;
                                   pierceBuilding = true;
                                   hitSize = 4;
                                   trailLength = 7;
                                   trailWidth = 1.3f;
                                }};
                           }}
                    );
                    drawer = new DrawTurret("thezsia-"){{
                        parts.add(new RegionPart("-side"){{
                            mirror = true;
                            under = true;
                            outline = true;
                            progress = PartProgress.recoil;
                            heatProgress = PartProgress.warmup;
                            moveX = 0.7f;
                            moveY = -0.8f;
                            moveRot = -18;
                            heatColor = Color.valueOf("FFA665FF");
                        }});
                    }};
               }};

               gaze = new PowerTurret("gaze"){{
                    requirements(Category.turret, ItemStack.with(beryllium, 125, ThezItems.silver, 75, ThezItems.tensorite, 50));
                    size = 3;
                    coolant = consume(new ConsumeCoolant(0.1f, true, true));
                    minWarmup = 0.95f;
                    shootWarmupSpeed = 0.03f;
                    consumePower(5);
                    rotateSpeed = 2.5f;
                    outlineColor = Color.valueOf("19181AFF");
                    targetAir = false;
                    targetGround = true;
                    reload = 4;
                    range = 180;
                    fogRadiusMultiplier = 0.35f;
                    inaccuracy = 45;
                    velocityRnd = 0.2f;
                    shootY = 8.7f;
                    shootSound = Sounds.malignShoot;
                    shake = 1;
                    cooldownTime = 90;
                    shootType = new MissileBulletType(){{
                        smokeEffect = Fx.shootSmokeSmite;
                        weaveMag = 3;
                        weaveScale = 2;
                        frontColor = trailColor = Color.valueOf("AEF2CBFF");
                        backColor = Color.valueOf("2CDC78FF");
                        hitEffect = Fx.hitSquaresColor;
                        despawnEffect = Fx.hitLancer;
                        homingPower = 0.03f;
                        width = height = 8;
                        speed = 5.5f;
                        lifetime = 40;
                        despawnShake = 0.4f;
                        hitShake = 0.8f;
                        damage = 13;
                        pierce = true;
                        pierceCap = 2;
                        pierceBuilding = true;
                        trailLength = 20;
                        trailWidth = 2;
                    }};
                    drawer = new DrawTurret("thezsia-"){{
                       parts.addAll(new RegionPart("-side"){{
                               mirror = true;
                               under = true;
                               outline = true;
                               progress = PartProgress.warmup;
                               heatProgress = PartProgress.warmup;
                               moveX = 3;
                               moveY = 2.5f;
                               moveRot = -28;
                               heatColor = Color.valueOf("2CDC78FF");
                           }},
                               new RegionPart("-mid"){{
                                   mirror = true;
                                   under = true;
                                   outline = true;
                                   progress = PartProgress.warmup;
                                   heatProgress = PartProgress.warmup;
                                   moveX = 3;
                                   moveY = -0.3f;
                                   moveRot = -8;
                                   heatColor = Color.valueOf("2CDC78FF");
                               }},
                               new RegionPart("-front"){{
                                   mirror = true;
                                   under = true;
                                   outline = true;
                                   progress = PartProgress.warmup;
                                   heatProgress = PartProgress.warmup;
                                   moveX = 10;
                                   moveY = -3.3f;
                                   moveRot = -10;
                                   heatColor = Color.valueOf("2CDC78FF");
                               }},
                               new ShapePart(){{
                                   progress = PartProgress.warmup;
                                   circle = true;
                                   hollow = true;
                                   color = Color.valueOf("2CDC78FF");
                                   stroke = 0;
                                   strokeTo = 1;
                                   radius = 7.3f;
                                   y = 8.7f;
                               }},
                               new ShapePart(){{
                                   progress = PartProgress.warmup;
                                   rotateSpeed = 1;
                                   sides = 3;
                                   hollow = true;
                                   color = Color.valueOf("2CDC78FF");
                                   stroke = 0;
                                   strokeTo = 1.2f;
                                   radius = 7;
                                   y = 8.7f;
                               }},
                               new ShapePart(){{
                                   progress = PartProgress.warmup;
                                   rotateSpeed = 0.7f;
                                   sides = 3;
                                   hollow = true;
                                   color = Color.valueOf("2CDC78FF");
                                   stroke = 0;
                                   strokeTo = 1.1f;
                                   radius = 4;
                                   y = 8.7f;
                               }},
                               new HaloPart(){{
                                   progress = PartProgress.warmup;
                                   rotateSpeed = -1.3f;
                                   tri = true;
                                   shapes = 3;
                                   triLength = 0;
                                   triLengthTo = 3;
                                   radius = 3;
                                   haloRadius = 7;
                                   haloRotateSpeed = -1.3f;
                                   color = Color.valueOf("2CDC78FF");
                                   haloRotation = 180;
                                   shapeRotation = 180;
                                   radius = 6;
                                   y = 8.7f;
                               }}
                           );
                    }};
               }};

               //units (blocks)
               groundFabricator = new UnitFactory("ground-fabricator"){{
                    requirements(Category.units, ItemStack.with(beryllium,50, ThezItems.tensorite, 30));
                    size = 3;
                    health = 600;

                    consumePower(3);

                    plans.addAll(
                            new UnitPlan(ThezUnitTypes.noctis, 600, with(beryllium, 15, ThezItems.silver, 8)),
                            new UnitPlan(ThezUnitTypes.ignis, 560, with(beryllium, 20, ThezItems.infium, 12))
                    );
               }};

               //payloads
               massConveyor = new PayloadConveyor("mass-conveyor"){{
                    requirements(Category.units, ItemStack.with(beryllium, 16, ThezItems.basaltShard, 8));
                    canOverdrive = false;
                    payloadLimit = 3;
               }};
               massRouter = new PayloadConveyor("mass-router"){{
                    requirements(Category.units, ItemStack.with(beryllium, 20, ThezItems.basaltShard, 10));
                    canOverdrive = false;
               }};

               //logic


               //sandbox


               //campaign

            }
        }
    }
}