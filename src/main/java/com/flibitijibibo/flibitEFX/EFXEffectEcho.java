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

public class EFXEffectEcho extends EFXEffect {
	
	/** Constructor creates a generic echo effect. */
	public EFXEffectEcho() {
		super(EFX10.AL_EFFECT_ECHO);
	}
	
	/** Sets the amount of high frequency damping to apply to the echo effect.
	 * @param passedValue The new damping value to apply to the echo effect
	 */
	public void setDamping(float passedValue) {
		if (passedValue < EFX10.AL_ECHO_MIN_DAMPING)
			addEffectf(EFX10.AL_ECHO_DAMPING, EFX10.AL_ECHO_MIN_DAMPING);
		else if (passedValue > EFX10.AL_ECHO_MAX_DAMPING)
			addEffectf(EFX10.AL_ECHO_DAMPING, EFX10.AL_ECHO_MAX_DAMPING);
		else
			addEffectf(EFX10.AL_ECHO_DAMPING, passedValue);
	}
	
	/** Sets the echo effect's delay time.
	 * @param passedValue The echo effect's new delay time
	 */
	public void setDelay(float passedValue) {
		if (passedValue < EFX10.AL_ECHO_MIN_DELAY)
			addEffectf(EFX10.AL_ECHO_DELAY, EFX10.AL_ECHO_MIN_DELAY);
		else if (passedValue > EFX10.AL_ECHO_MAX_DELAY)
			addEffectf(EFX10.AL_ECHO_DELAY, EFX10.AL_ECHO_MAX_DELAY);
		else
			addEffectf(EFX10.AL_ECHO_DELAY, passedValue);
	}
	
	/** Sets the amount of feedback to echo back.
	 * @param passedValue The new feedback volume of the echo effect
	 */
	public void setFeedback(float passedValue) {
		if (passedValue < EFX10.AL_ECHO_MIN_FEEDBACK)
			addEffectf(EFX10.AL_ECHO_FEEDBACK, EFX10.AL_ECHO_MIN_FEEDBACK);
		else if (passedValue > EFX10.AL_ECHO_MAX_FEEDBACK)
			addEffectf(EFX10.AL_ECHO_FEEDBACK, EFX10.AL_ECHO_MAX_FEEDBACK);
		else
			addEffectf(EFX10.AL_ECHO_FEEDBACK, passedValue);
	}
	
	/** Sets the delay between each echo "tap".
	 * @param passedValue The new delay time between each echo "tap"
	 */
	public void setLRDelay(float passedValue) {
		if (passedValue < EFX10.AL_ECHO_MIN_LRDELAY)
			addEffectf(EFX10.AL_ECHO_LRDELAY, EFX10.AL_ECHO_MIN_LRDELAY);
		else if (passedValue > EFX10.AL_ECHO_MAX_LRDELAY)
			addEffectf(EFX10.AL_ECHO_LRDELAY, EFX10.AL_ECHO_MAX_LRDELAY);
		else
			addEffectf(EFX10.AL_ECHO_LRDELAY, passedValue);
	}
	
	/** Sets the amount of hard panning allowed for each echo.
	 * @param passedValue The new level of flexibility for the echo effect's panning
	 */
	public void setSpread(float passedValue) {
		if (passedValue < EFX10.AL_ECHO_MIN_SPREAD)
			addEffectf(EFX10.AL_ECHO_SPREAD, EFX10.AL_ECHO_MIN_SPREAD);
		else if (passedValue > EFX10.AL_ECHO_MAX_SPREAD)
			addEffectf(EFX10.AL_ECHO_SPREAD, EFX10.AL_ECHO_MAX_SPREAD);
		else
			addEffectf(EFX10.AL_ECHO_SPREAD, passedValue);
	}
}