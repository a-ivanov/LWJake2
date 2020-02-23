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

public class EFXEffectReverb extends EFXEffect {
	
	/** Constructor creates a generic reverb effect. */
	public EFXEffectReverb() {
		super(EFX10.AL_EFFECT_REVERB);
	}
	
	// TODO: Add methods for all AL_EFFECT_REVERB properties.
}