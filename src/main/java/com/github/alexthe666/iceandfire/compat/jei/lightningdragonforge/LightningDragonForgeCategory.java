package com.github.alexthe666.iceandfire.compat.jei.lightningdragonforge;

import com.github.alexthe666.iceandfire.recipe.DragonForgeRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class LightningDragonForgeCategory implements IRecipeCategory<DragonForgeRecipe> {

    public LightningDragonForgeDrawable drawable;

    public LightningDragonForgeCategory() {
        drawable = new LightningDragonForgeDrawable();
    }


/*    @Override
    public @NotNull ResourceLocation getUid() {
        return IceAndFireJEIPlugin.LIGHTNING_DRAGON_FORGE_ID;
    }*/

    @Override
    public @NotNull RecipeType<DragonForgeRecipe> getRecipeType() {
        return DragonForgeRecipe.LIGHTNING_DRAGON_FORGE_RECIPE_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("iceandfire.lightning_dragon_forge");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return drawable;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return null;
    }

/*    @Override
    public void setIngredients(DragonForgeRecipe dragonForgeRecipe, IIngredients iIngredients) {
        List<Ingredient> ingredientsList = new ArrayList<>();
        ingredientsList.add(dragonForgeRecipe.getInput());
        ingredientsList.add(dragonForgeRecipe.getBlood());
        iIngredients.setInputIngredients(ingredientsList);
        iIngredients.setOutput(VanillaTypes.ITEM, dragonForgeRecipe.getResultItem());
    }*/

    @Override
    public void setRecipe(IRecipeLayoutBuilder recipeLayoutBuilder, @NotNull DragonForgeRecipe dragonForgeRecipe, @NotNull IFocusGroup focuses) {
        recipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 64, 29)
                .addIngredients(dragonForgeRecipe.getBlood());
        recipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 82, 29)
                .addIngredients(dragonForgeRecipe.getInput());
        recipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 144, 30)
                .addItemStack(dragonForgeRecipe.getResultItem(Minecraft.getInstance().level.registryAccess()));
    }
}
