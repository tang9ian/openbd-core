/* 
 *  Copyright (C) 2000 - 2008 TagServlet Ltd
 *
 *  This file is part of Open BlueDragon (OpenBD) CFML Server Engine.
 *  
 *  OpenBD is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  Free Software Foundation,version 3.
 *  
 *  OpenBD is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with OpenBD.  If not, see http://www.gnu.org/licenses/
 *  
 *  Additional permission under GNU GPL version 3 section 7
 *  
 *  If you modify this Program, or any covered work, by linking or combining 
 *  it with any of the JARS listed in the README.txt (or a modified version of 
 *  (that library), containing parts covered by the terms of that JAR, the 
 *  licensors of this Program grant you additional permission to convey the 
 *  resulting work. 
 *  README.txt @ http://www.openbluedragon.org/license/README.txt
 *  
 *  http://www.openbluedragon.org/
 */

package com.naryx.tagfusion.expression.function.string;

import com.naryx.tagfusion.cfm.engine.cfArgStructData;
import com.naryx.tagfusion.cfm.engine.cfData;
import com.naryx.tagfusion.cfm.engine.cfSession;
import com.naryx.tagfusion.cfm.engine.cfStringData;
import com.naryx.tagfusion.cfm.engine.cfmRunTimeException;
import com.naryx.tagfusion.expression.function.functionBase;

public class mid extends functionBase {

	private static final long serialVersionUID = 1L;

	public mid() {
		min = max = 3;
		setNamedParams( new String[]{ "string", "start", "number"} );
	}

	public String[] getParamInfo(){
		return new String[]{
			"string",
			"start position",
			"number of characters"
		};
	}
	
	public java.util.Map getInfo(){
		return makeInfo(
				"string", 
				"Returns substring within the string from the start position for the number of characters", 
				ReturnType.STRING );
	}
	
	
	public cfData execute(cfSession _session, cfArgStructData argStruct ) throws cfmRunTimeException {

		String value = getNamedStringParam(argStruct, "string","");
		int start = getNamedIntParam(argStruct, "start",0);
		int count = getNamedIntParam(argStruct, "number",-1);

		if (start < 1)
			throwException(_session, "The second (start) parameter of the Mid() function must be 1 or greater");

		if (count < 0)
			throwException(_session, "The third (count) parameter of the Mid() function must be 0 or greater");

		start -= 1;

		if (start > value.length()) {
			return new cfStringData("");
		} else if ((start + count) > value.length()) {
			return new cfStringData(value.substring(start));
		} else {
			return new cfStringData(value.substring(start, start + count));
		}
	}
}