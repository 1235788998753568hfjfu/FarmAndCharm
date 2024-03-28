package satisfy.farmcharm.registry;

import de.cristelknight.doapi.Util;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.*;
import satisfy.farmcharm.FarmCharm;
import satisfy.farmcharm.FarmCharmIdentifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import satisfy.farmcharm.block.CookingPanBlock;
import satisfy.farmcharm.block.CookingPotBlock;
import satisfy.farmcharm.block.ToolRackBlock;
import satisfy.farmcharm.block.crops.*;
import satisfy.farmcharm.item.CookingPanItem;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ObjectRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(FarmCharm.MOD_ID, Registries.ITEM);
    public static final Registrar<Item> ITEM_REGISTRAR = ITEMS.getRegistrar();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(FarmCharm.MOD_ID, Registries.BLOCK);
    public static final Registrar<Block> BLOCK_REGISTRAR = BLOCKS.getRegistrar();

    public static final RegistrySupplier<Block> TOMATO_CROP = registerWithoutItem("tomato_crop", () -> new TomatoCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistrySupplier<Item> TOMATO_SEEDS = registerItem("tomato_seeds", () -> new ItemNameBlockItem(TOMATO_CROP.get(), getSettings()));
    public static final RegistrySupplier<Item>  TOMATO = registerItem("tomato", () -> new Item(getSettings().food(Foods.APPLE)));
    public static final RegistrySupplier<Block> LETTUCE_CROP = registerWithoutItem("lettuce_crop", () -> new LettuceCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistrySupplier<Item> LETTUCE_SEEDS = registerItem("lettuce_seeds", () -> new ItemNameBlockItem(LETTUCE_CROP.get(), getSettings()));
    public static final RegistrySupplier<Item> LETTUCE = registerItem("lettuce", () -> new Item(getSettings().food(Foods.CARROT)));
     public static final RegistrySupplier<Block> STRAWBERRY_CROP = registerWithoutItem("strawberry_crop", () -> new StrawberryCropBlock(getBushSettings()));
    public static final RegistrySupplier<Item> STRAWBERRY_SEEDS = registerItem("strawberry_seeds", () -> new BlockItem(STRAWBERRY_CROP.get(), getSettings()));
    public static final RegistrySupplier<Item> STRAWBERRY = registerItem("strawberry", () -> new Item(getSettings().food(Foods.BEETROOT)));
    public static final RegistrySupplier<Block> OAT_CROP = registerWithoutItem("oat_crop", () -> new OatCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistrySupplier<Item> OAT_SEEDS = registerItem("oat_seeds", () -> new BlockItem(OAT_CROP.get(), getSettings()));
    public static final RegistrySupplier<Item> OAT = registerItem("oat", () -> new Item(getSettings().food(Foods.BEETROOT)));
    public static final RegistrySupplier<Block> BARLEY_CROP = registerWithoutItem("barley_crop", () -> new BarleyCropBlock(getBushSettings()));
    public static final RegistrySupplier<Item> BARLEY_SEEDS = registerItem("barley_seeds", () -> new BlockItem(BARLEY_CROP.get(), getSettings()));
    public static final RegistrySupplier<Item> BARLEY = registerItem("barley", () -> new Item(getSettings().food(Foods.APPLE)));
    public static final RegistrySupplier<Block> CORN_CROP = registerWithoutItem("corn_crop", () -> new CornCropBlock(getBushSettings()));
    public static final RegistrySupplier<Item> CORN_SEEDS = registerItem("corn_seeds", () -> new BlockItem(CORN_CROP.get(), getSettings()));
    public static final RegistrySupplier<Item> CORN = registerItem("corn", () -> new Item(getSettings().food(Foods.APPLE)));



    public static final RegistrySupplier<Block> STRAWBERRY_BAG = registerWithItem("strawberry_bag", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_WOOL)));
    public static final RegistrySupplier<Block> CARROT_BAG = registerWithItem("carrot_bag", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_WOOL)));
    public static final RegistrySupplier<Block> POTATO_BAG = registerWithItem("potato_bag", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_WOOL)));
    public static final RegistrySupplier<Block> BEETROOT_BAG = registerWithItem("beetroot_bag", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_WOOL)));
    public static final RegistrySupplier<Block> LETTUCE_BAG = registerWithItem("lettuce_bag", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_WOOL)));
    public static final RegistrySupplier<Block> TOMATO_BAG = registerWithItem("tomato_bag", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_WOOL)));
    public static final RegistrySupplier<Block> OAT_BAG = registerWithItem("oat_bag", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_WOOL)));

    public static final RegistrySupplier<Block> OAT_BLOCK = registerWithItem("oat_block", () -> new HayBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).strength(2.0F, 3.0F).sound(SoundType.GRASS)));
    public static final RegistrySupplier<Block> OAT_STAIRS = registerWithItem("oat_stairs", () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.GRASS)));
    public static final RegistrySupplier<Block> OAT_SLAB = registerWithItem("oat_slab", () -> new SlabBlock(getSlabSettings().sound(SoundType.GRASS)));

    public static final RegistrySupplier<Block> COOKING_POT = registerWithItem("cooking_pot", () -> new CookingPotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistrySupplier<Block> COOKING_PAN = registerWithoutItem("cooking_pan", () -> new CookingPanBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistrySupplier<Item> COOKING_PAN_ITEM = registerItem("cooking_pan", () -> new CookingPanItem(COOKING_PAN.get(), getSettings()));


    public static final RegistrySupplier<Block> TOOL_RACK = registerWithItem("tool_rack", () -> new ToolRackBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).noCollission()));

    public static final RegistrySupplier<Item> BUTTER = registerItem("butter", () -> new Item(getSettings()));
    public static final RegistrySupplier<Item> MOZZARELLA = registerItem("mozzarella", () -> new Item(getSettings().food(Foods.BREAD)));
    public static final RegistrySupplier<Item> DOUGH = registerItem("dough", () -> new Item(getSettings()));


    public static final RegistrySupplier<Block> WILD_TOMATOES = registerWithItem("wild_tomatoes", () -> new FlowerBlock(MobEffects.HEAL, 1,BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> WILD_LETTUCE = registerWithItem("wild_lettuce", () -> new FlowerBlock(MobEffects.HEAL, 1, BlockBehaviour.Properties.copy(Blocks.POPPY)));
    public static final RegistrySupplier<Block> WILD_STRAWBERRIES = registerWithItem("wild_strawberries", () -> new FlowerBlock(MobEffects.HEAL, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));




public static void init() {
        FarmCharm.LOGGER.debug("Registering Mod Block and Items for " + FarmCharm.MOD_ID);
        ITEMS.register();
        BLOCKS.register();
    }

    public static BlockBehaviour.Properties properties(float strength) {
        return properties(strength, strength);
    }

    public static BlockBehaviour.Properties properties(float breakSpeed, float explosionResist) {
        return BlockBehaviour.Properties.of().strength(breakSpeed, explosionResist);
    }


    private static Item.Properties getSettings(Consumer<Item.Properties> consumer) {
        Item.Properties settings = new Item.Properties();
        consumer.accept(settings);
        return settings;
    }

    static Item.Properties getSettings() {
        return getSettings(settings -> {
        });
    }

    private static BlockBehaviour.Properties getLogBlockSettings() {
        return BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD);
    }

    private static BlockBehaviour.Properties getSlabSettings() {
        return getLogBlockSettings().explosionResistance(3.0F);
    }

    private static BlockBehaviour.Properties getBushSettings() {
        return BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH);
    }

    public static <T extends Block> RegistrySupplier<T> registerWithItem(String name, Supplier<T> block) {
        return Util.registerWithItem(BLOCKS, BLOCK_REGISTRAR, ITEMS, ITEM_REGISTRAR, new FarmCharmIdentifier(name), block);
    }

    public static <T extends Block> RegistrySupplier<T> registerWithoutItem(String path, Supplier<T> block) {
        return Util.registerWithoutItem(BLOCKS, BLOCK_REGISTRAR, new FarmCharmIdentifier(path), block);
    }

    public static <T extends Item> RegistrySupplier<T> registerItem(String path, Supplier<T> itemSupplier) {
        return Util.registerItem(ITEMS, ITEM_REGISTRAR, new FarmCharmIdentifier(path), itemSupplier);
    }
}
