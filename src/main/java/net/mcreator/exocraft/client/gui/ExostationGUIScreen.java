
package net.mcreator.exocraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.exocraft.world.inventory.ExostationGUIMenu;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ExostationGUIScreen extends AbstractContainerScreen<ExostationGUIMenu> {
	private final static HashMap<String, Object> guistate = ExostationGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox exocraft__type;

	public ExostationGUIScreen(ExostationGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 255;
		this.imageHeight = 208;
	}

	private static final ResourceLocation texture = new ResourceLocation("exocraft:textures/screens/exostation_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		exocraft__type.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (exocraft__type.isFocused())
			return exocraft__type.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		exocraft__type.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		exocraft__type = new EditBox(this.font, this.leftPos + 25, this.topPos + 92, 120, 20, Component.literal("choose an exocraft to summon")) {
			{
				setSuggestion("choose an exocraft to summon");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("choose an exocraft to summon");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("choose an exocraft to summon");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:exocraft__type", exocraft__type);
		exocraft__type.setMaxLength(32767);
		this.addWidget(this.exocraft__type);
		this.addRenderableWidget(new Button(this.leftPos + 25, this.topPos + 17, 61, 20, Component.literal("Exosuit"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 25, this.topPos + 42, 51, 20, Component.literal("Racer"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 25, this.topPos + 67, 40, 20, Component.literal("Sub"), e -> {
		}));
	}
}
