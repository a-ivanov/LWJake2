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

public abstract class EFXFilter {
	
	private int filterIndex;
	
	/** Constructor creates an EFX effect slot containing a filter.
	 * @param efxFilter The EFX10 filter type (i.e. EFX10.AL_FILTER_HIGHPASS)
	 */
	public EFXFilter(int efxFilter) {
		filterIndex = EFX10.alGenFilters();
		// TODO: Check to see if efxFilter is a valid AL_FILTER_TYPE.
		EFX10.alFilteri(filterIndex, EFX10.AL_FILTER_TYPE, efxFilter);
	}
	
	/** Unloads the EFX filter. */
	public void killFilter() {
		EFX10.alDeleteFilters(filterIndex);
	}
	
	/** Returns the index of the EFX filter.
	 * @return The index of the EFX filter
	 */
	public int getIndex() {
		return filterIndex;
	}
	
	/** Applies a filter property to this EFX filter.
	 * @param passedProperty The EFX10 filter property
	 * @param passedValue The EFX10 filter value
	 */
	protected void addFilter(int passedProperty, float passedValue) {
		EFX10.alFilterf(filterIndex, passedProperty, passedValue);
	}
}