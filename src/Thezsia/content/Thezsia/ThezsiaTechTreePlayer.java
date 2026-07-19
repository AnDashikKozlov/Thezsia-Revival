package Thezsia.content.Thezsia;

import Thezsia.content.ThezPlanets;
import Thezsia.content.Thezsia.blocks.ThezsiaStorages;
import arc.struct.Seq;
import mindustry.content.Planets;
import mindustry.game.Objectives;

import static Thezsia.content.Thezsia.blocks.ThezsiaDistribution.*;
import static mindustry.content.Blocks.coreBastion;
import static mindustry.content.Blocks.duct;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeRoot;

public class ThezsiaTechTreePlayer{
    public static void load(){
        Seq<Objectives.Objective> thezsiaSector = Seq.with(new Objectives.OnPlanet(ThezPlanets.planetThezsia));

        ThezPlanets.planetThezsia.techTree = nodeRoot("techTree.Player", ThezsiaStorages.coreDust, true, () -> {
            node(tantalumBelt, thezsiaSector, () -> {
                node(tantalumJunction, thezsiaSector, () -> {
                    node(tantalumBridge, thezsiaSector, () -> {
                        node(tantalumRouter, thezsiaSector, () -> {});
                    });
                });
                node(tantalumSorter, thezsiaSector, () -> {
                    node(invertedTantalumSorter, thezsiaSector, () -> {});
                });
                node(tantalumSpillwayGate, thezsiaSector, () -> {
                    node(invertedTantalumSpillwayGate, thezsiaSector, () -> {});
                });
            });
        });
    }
}
