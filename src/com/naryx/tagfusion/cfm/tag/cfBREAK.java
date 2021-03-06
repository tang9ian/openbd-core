/* 
 *  Copyright (C) 2000 - 2010 TagServlet Ltd
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

package com.naryx.tagfusion.cfm.tag;

import java.io.Serializable;

import com.naryx.tagfusion.cfm.engine.catchDataFactory;
import com.naryx.tagfusion.cfm.engine.cfSession;
import com.naryx.tagfusion.cfm.engine.cfmBadFileException;

public class cfBREAK extends cfTag implements Serializable {
	static final long serialVersionUID = 1;

	public java.util.Map getInfo() {
		return createInfo("control", "For use within the CFLOOP tag, allowing you to break out the current loop iterations");
	}

	protected void defaultParameters(String _tag) throws cfmBadFileException {
		if (!this.isSubordinate("CFLOOP", false) && !this.isSubordinate("CFFUNCTION", false) && !this.isSubordinate("CFCASE", false)) {
			throw new cfmBadFileException(catchDataFactory.invalidTagAttributeException(this, "CFBREAK is only valid within CFLOOP/CFFUNCTION/CFCASE"));
		}
	}

	public cfTagReturnType render(cfSession _Session) {
		return cfTagReturnType.BREAK;
	}
}
