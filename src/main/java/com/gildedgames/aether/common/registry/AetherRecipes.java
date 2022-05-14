package com.gildedgames.aether.common.registry;

import com.gildedgames.aether.Aether;

import com.gildedgames.aether.common.recipe.*;
import com.gildedgames.aether.common.recipe.serializer.BlockStateRecipeSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraftforge.registries.RegistryObject;

public class AetherRecipes
{
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Aether.MODID);

	public static final RegistryObject<RecipeSerializer<AltarRepairRecipe>> REPAIRING = RECIPE_SERIALIZERS.register("repairing", AltarRepairRecipe.Serializer::new);
	public static final RegistryObject<SimpleCookingSerializer<EnchantingRecipe>> ENCHANTING = RECIPE_SERIALIZERS.register("enchanting", EnchantingRecipe.Serializer::new);
	public static final RegistryObject<SimpleCookingSerializer<FreezingRecipe>> FREEZING = RECIPE_SERIALIZERS.register("freezing", FreezingRecipe.Serializer::new);
	public static final RegistryObject<BlockStateRecipeSerializer<SwetBallRecipe>> SWET_BALL_CONVERSION = RECIPE_SERIALIZERS.register("swet_ball_conversion", SwetBallRecipe.Serializer::new);
	public static final RegistryObject<BlockStateRecipeSerializer<IcestoneFreezableRecipe>> ICESTONE_FREEZABLE = RECIPE_SERIALIZERS.register("icestone_freezable", IcestoneFreezableRecipe.Serializer::new);
	public static final RegistryObject<BlockStateRecipeSerializer<AccessoryFreezableRecipe>> ACCESSORY_FREEZABLE = RECIPE_SERIALIZERS.register("accessory_freezable", AccessoryFreezableRecipe.Serializer::new);
	public static final RegistryObject<BlockStateRecipeSerializer<PlacementConversionRecipe>> PLACEMENT_CONVERSION = RECIPE_SERIALIZERS.register("placement_conversion", PlacementConversionRecipe.Serializer::new);
	public static final RegistryObject<ItemBanRecipe.Serializer> ITEM_PLACEMENT_BAN = RECIPE_SERIALIZERS.register("item_placement_ban", ItemBanRecipe.Serializer::new);

	public static class RecipeTypes
	{
		public static RecipeType<EnchantingRecipe> ENCHANTING;
		public static RecipeType<FreezingRecipe> FREEZING;
		public static RecipeType<SwetBallRecipe> SWET_BALL_CONVERSION;
		public static RecipeType<IcestoneFreezableRecipe> ICESTONE_FREEZABLE;
		public static RecipeType<AccessoryFreezableRecipe> ACCESSORY_FREEZABLE;
		public static RecipeType<PlacementConversionRecipe> PLACEMENT_CONVERSION;
		public static RecipeType<ItemBanRecipe> ITEM_PLACEMENT_BAN;

		public static void init() {
			ENCHANTING = RecipeType.register(new ResourceLocation(Aether.MODID, "enchanting").toString());
			FREEZING = RecipeType.register(new ResourceLocation(Aether.MODID, "freezing").toString());
			SWET_BALL_CONVERSION = RecipeType.register(new ResourceLocation(Aether.MODID, "swet_ball_conversion").toString());
			ICESTONE_FREEZABLE = RecipeType.register(new ResourceLocation(Aether.MODID, "icestone_freezable").toString());
			ACCESSORY_FREEZABLE = RecipeType.register(new ResourceLocation(Aether.MODID, "accessory_freezable").toString());
			PLACEMENT_CONVERSION = RecipeType.register(new ResourceLocation(Aether.MODID, "placement_conversion").toString());
			ITEM_PLACEMENT_BAN = RecipeType.register(new ResourceLocation(Aether.MODID, "item_placement_ban").toString());
		}
	}
}
