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

public class EFXEffectRingModulator extends EFXEffect {
	
	public static final int SINUSOID = EFX10.AL_RING_MODULATOR_SINUSOID;
	public static final int SAWTOOTH = EFX10.AL_RING_MODULATOR_SAWTOOTH;
	public static final int SQUARE = EFX10.AL_RING_MODULATOR_SQUARE;
	
	/** Constructor creates a generic ring modulator effect. */
	public EFXEffectRingModulator() {
		super(EFX10.AL_EFFECT_RING_MODULATOR);
	}
	
	/** Sets the frequency of the ring modulator.
	 * @param passedValue The new frequency of the ring modulator
	 */
	public void setFrequency(float passedValue) {
		if (passedValue > EFX10.AL_RING_MODULATOR_MAX_FREQUENCY)
			addEffectf(EFX10.AL_RING_MODULATOR_FREQUENCY, EFX10.AL_RING_MODULATOR_MAX_FREQUENCY);
		else if (passedValue < EFX10.AL_RING_MODULATOR_MIN_FREQUENCY)
			addEffectf(EFX10.AL_RING_MODULATOR_FREQUENCY, EFX10.AL_RING_MODULATOR_MIN_FREQUENCY);
		else
			addEffectf(EFX10.AL_RING_MODULATOR_FREQUENCY, passedValue);
	}
	
	/** Sets the high-pass cutoff for the ring modulator.
	 * @param passedValue The new cutoff value for the ring modulator high-pass filter
	 */
	public void setHighPassCutoff(float passedValue) {
		if (passedValue > EFX10.AL_RING_MODULATOR_MAX_HIGHPASS_CUTOFF)
			addEffectf(EFX10.AL_RING_MODULATOR_HIGHPASS_CUTOFF, EFX10.AL_RING_MODULATOR_MAX_HIGHPASS_CUTOFF);
		else if (passedValue < EFX10.AL_RING_MODULATOR_MIN_HIGHPASS_CUTOFF)
			addEffectf(EFX10.AL_RING_MODULATOR_HIGHPASS_CUTOFF, EFX10.AL_RING_MODULATOR_MIN_HIGHPASS_CUTOFF);
		else
			addEffectf(EFX10.AL_RING_MODULATOR_HIGHPASS_CUTOFF, passedValue);
	}
	
	/** Sets the waveform of the ring modulator.
	 * @param waveform Should be EFXEffectRingModulator.SINUSOID, SAWTOOTH or SQUARE
	 */
	public void setWaveform(int waveform) {
		if (waveform != SINUSOID && waveform != SAWTOOTH && waveform != SQUARE)
			return;
		addEffecti(EFX10.AL_RING_MODULATOR_WAVEFORM, waveform);
	}
}