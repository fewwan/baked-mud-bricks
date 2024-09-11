package fewwan.bakedmudbricks;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BakedMudBricks implements ModInitializer {
	public static final String MOD_ID = "bakedmudbricks";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Block BAKED_PACKED_MUD = new Block(AbstractBlock.Settings.create().mapColor(MapColor.RAW_IRON_PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(2.0f, 6.0f).sounds(BlockSoundGroup.STONE));
	public static final Block BAKED_MUD_BRICKS = new Block(AbstractBlock.Settings.create().mapColor(MapColor.RAW_IRON_PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(2.0f, 6.0f).sounds(BlockSoundGroup.STONE));
	public static final Block BAKED_MUD_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copyShallow(BAKED_MUD_BRICKS));
	public static final Block BAKED_MUD_BRICK_STAIRS = new StairsBlock(BAKED_MUD_BRICKS.getDefaultState(), AbstractBlock.Settings.copyShallow(BAKED_MUD_BRICKS));
	public static final Block BAKED_MUD_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copyShallow(BAKED_MUD_BRICKS).solid());

	@Override
	public void onInitialize() {
		Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, "baked_packed_mud"), BAKED_PACKED_MUD);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "baked_packed_mud"), new BlockItem(BAKED_PACKED_MUD, new Item.Settings()));

		Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, "baked_mud_bricks"), BAKED_MUD_BRICKS);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "baked_mud_bricks"), new BlockItem(BAKED_MUD_BRICKS, new Item.Settings()));

		Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, "baked_mud_brick_slab"), BAKED_MUD_BRICK_SLAB);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "baked_mud_brick_slab"), new BlockItem(BAKED_MUD_BRICK_SLAB, new Item.Settings()));

		Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, "baked_mud_brick_stairs"), BAKED_MUD_BRICK_STAIRS);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "baked_mud_brick_stairs"), new BlockItem(BAKED_MUD_BRICK_STAIRS, new Item.Settings()));

		Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, "baked_mud_brick_wall"), BAKED_MUD_BRICK_WALL);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "baked_mud_brick_wall"), new BlockItem(BAKED_MUD_BRICK_WALL, new Item.Settings()));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
			content.add(BAKED_PACKED_MUD);
			content.add(BAKED_MUD_BRICKS);
			content.add(BAKED_MUD_BRICK_SLAB);
			content.add(BAKED_MUD_BRICK_STAIRS);
			content.add(BAKED_MUD_BRICK_WALL);
		});
	}
}