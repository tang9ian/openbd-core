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

package com.naryx.tagfusion.cfm.queryofqueries;

/**
 * This class represents a string expression.
 * Note that since it returns the same cfStringData every time
 * on evaluation it is not safe to operate on it.
 */
 
import java.util.List;
import java.util.Map;

import com.naryx.tagfusion.cfm.engine.cfData;
import com.naryx.tagfusion.cfm.engine.cfStringData;
import com.naryx.tagfusion.cfm.engine.cfmRunTimeException;
 
public class stringExpression extends expression {

	cfStringData theString;
	
	boolean isAggregateFunction(){
		return false;
	}
	
	// _str is the string with the enclosing quotes
	public stringExpression( String _str ){
		theString = new cfStringData( _str.substring(1, _str.length()-1) );
		
	}// stringExpression()

	
	/**
	 * Note that since it returns the same cfStringData every time
   * on evaluation it is not safe to operate on it.
	 */
	public cfData evaluate( rowContext _rowContext, List<cfData> _preparedData ){
		return theString;
	}
	
	public cfData evaluate( ResultRow _row, List<cfData> data, Map<String, Integer> _indexLookup ) throws cfmRunTimeException {
		return theString;
	}

}// expression
