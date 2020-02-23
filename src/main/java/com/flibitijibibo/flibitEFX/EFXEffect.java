/* 
 * Copyright (C) 2011 Ethan "flibitijibibo" Lee
 * 
 * This file is part of flibitEFX.
 * 
 * flibitEFX is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * flibitEFX is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with flibitEFX.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.flibitijibibo.flibitEFX;

import org.lwjgl.openal.EFX10;

/**
 * @author Ethan "flibitijibibo" Lee
 */

public abstract class EFXEffect {
	
	private int slotIndex;
	private int effectIndex;
	
	/** Constructor creates an EFX effect slot containing an effect.
	 * @param efxEffect The EFX10 effect type (i.e. EFX10.AL_EFFECT_REVERB)
	 */
	public EFXEffect(int efxEffect) {
		slotIndex = EFX10.alGenAuxiliaryEffectSlots();
		effectIndex = EFX10.alGenEffects();
		// TODO: Check to see if efxEffect is a valid AL_EFFECT_TYPE.
		EFX10.alEffecti(effectIndex, EFX10.AL_EFFECT_TYPE, efxEffect);
		EFX10.alAuxiliaryEffectSloti(slotIndex, EFX10.AL_EFFECTSLOT_EFFECT, effectIndex);
	}
	
	/** Unloads the EFX effect and effect slot. */
	public void killEffect() {
		EFX10.alDeleteEffects(effectIndex);
		EFX10.alDeleteAuxiliaryEffectSlots(slotIndex);
	}
	
	/** Returns the index of the EFX effect slot.
	 * @return The index of the EFX effect slot
	 */
	public int getIndex() {
		return slotIndex;
	}
	
	/** Applies an effect property to this EFX effect.
	 * @param passedProperty The EFX10 effect property
	 * @param passedValue The EFX10 effect value
	 */
	protected void addEffectf(int passedProperty, float passedValue) {
		EFX10.alEffectf(effectIndex, passedProperty, passedValue);
	}
	
	/** Applies an effect property to this EFX effect.
	 * @param passedProperty The EFX10 effect property
	 * @param passedValue The EFX10 effect value
	 */
	protected void addEffecti(int passedProperty, int passedValue) {
		EFX10.alEffecti(effectIndex, passedProperty, passedValue);
	}
}