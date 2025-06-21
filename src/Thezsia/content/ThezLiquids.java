package Thezsia.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

import static Thezsia.world.graphics.ThezPal.*;

public class ThezLiquids {
    public static Liquid
            lava, meltedTensorite, oxygen, carbonDioxide, ammonia, chlorine;
    public static void load() {

        lava = new Liquid("lava", liquidLava){{
            gas = false;
            gasColor = barColor = Color.valueOf("liquidLava");
            lightColor = Color.valueOf("e37644a6");

            flammability = 0.3f;
            temperature = 1.2f;
            heatCapacity = 0.1f;
            viscosity = 0.4f;

            coolant = false;
        }};
        meltedTensorite = new Liquid("melted-tensorite", liquidMeltedTensorite){{
            gas = false;
            gasColor = barColor = Color.valueOf("liquidMeltedTensorite");
            lightColor = Color.valueOf("4c7bc2b1");

            flammability = 0.07f;
            temperature = 0.87f;
            heatCapacity = 0.23f;
            viscosity = 0.67f;

            coolant = false;
        }};
        oxygen = new Liquid("oxygen", gasOxygen){{
            gas = true;
            gasColor = Color.valueOf("E6E6E600");
            barColor = Color.valueOf("E6E6E633");
            //lightColor = Color.valueOf("DEDEDEFF");

            flammability = 0.3f;
            temperature = 0.1f;
            heatCapacity = 0.2f;
            viscosity = 0.5f;

            coolant = false;
        }};
        carbonDioxide = new Liquid("carbon-dioxide", gasCarbonDioxide){{
            gas = true;
            gasColor = barColor = gasCarbonDioxide;
            //lightColor = Color.valueOf("5f626e");

            flammability = 0f;
            temperature = 0f;
            heatCapacity = 0.45f;
            viscosity = 0.35f;

            coolant = false;
        }};
        ammonia = new Liquid("ammonia", gasAmmonia){{
            gas = true;
            gasColor = barColor = Color.valueOf("gasAmmonia");
            //lightColor = Color.valueOf("988ca3");

            flammability = 0.15f;
            temperature = 0.2f;
            heatCapacity = 0.5f;
            viscosity = 0.08f;

            coolant = false;
        }};
    }
}
