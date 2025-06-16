package Thezsia.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class ThezLiquids {
    public static Liquid
            oxygen, lava, carbonDioxide, ammonia, meltedTensorite;
    public static void load() {

        oxygen = new Liquid("oxygen", Color.valueOf("FFFFFF00")){{
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
        lava = new Liquid("lava", Color.valueOf("CD6451FF")){{
            gas = false;
            gasColor = Color.valueOf("F08959FF");
            barColor = Color.valueOf("CD6451FF");
            lightColor = Color.valueOf("F08959FF");

            flammability = 0.3f;
            temperature = 0.6f;
            heatCapacity = 0.1f;
            viscosity = 0.4f;

            coolant = false;
        }};
        carbonDioxide = new Liquid("carbon-dioxide", Color.valueOf("c2c2c2")){{
            gas = true;
            gasColor = Color.valueOf("9a9da6");
            barColor = Color.valueOf("9a9da6");
            //lightColor = Color.valueOf("5f626e");

            flammability = 0f;
            temperature = 0f;
            heatCapacity = 0.45f;
            viscosity = 0.35f;

            coolant = false;
        }};
        ammonia = new Liquid("ammonia", Color.valueOf("dcbdf0")){{
            gas = true;
            gasColor = Color.valueOf("c29fcf");
            barColor = Color.valueOf("c29fcf");
            //lightColor = Color.valueOf("988ca3");

            flammability = 0.15f;
            temperature = 0.2f;
            heatCapacity = 0.5f;
            viscosity = 0.08f;

            coolant = false;
        }};
        meltedTensorite = new Liquid("melted-tensorite", Color.valueOf("82a1ed")){{
            gas = false;
            gasColor = Color.valueOf("4a6aba");
            barColor = Color.valueOf("6b64bd");
            lightColor = Color.valueOf("4a6aba");

            flammability = 0.07f;
            temperature = 0.87f;
            heatCapacity = 0.23f;
            viscosity = 0.67f;

            coolant = false;
        }};
    }
}
