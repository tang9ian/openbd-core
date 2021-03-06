/* 
 *  Copyright (C) 2000 - 2011 TagServlet Ltd
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
 *  
 *  $Id: cfZipItem.java 1538 2011-04-14 07:26:08Z alan $
 */

package com.naryx.tagfusion.cfm.tag.io;

import java.io.File;
import java.io.FilenameFilter;

public class cfZipItem {

	private File						src;
	private String					prefix;
	private String					newpath;
	private boolean					recurse;
	private FilenameFilter	filter;



	public cfZipItem(File _src, String _prefix) {
		this(_src, _prefix, null);
	}



	public cfZipItem(File _src, String _prefix, String _newpath) {
		src = _src;
		recurse = true;
		setPrefix(_prefix);
		setNewpath(_newpath);
	}



	private void setNewpath(String _p) {
		if (_p != null)
			newpath = _p.replace('\\', '/');
	}



	private void setPrefix(String _p) {
		prefix = _p.replace('\\', '/');
		if (prefix.length() != 0 && !prefix.endsWith("/")) {
			prefix = prefix + "/";
		}

	}



	public boolean getRecurse() {
		return recurse;
	}



	public void setRecurse(boolean _recurse) {
		recurse = _recurse;
	}



	public File getFile() {
		return src;
	}



	public String getPrefix() {
		return prefix;
	}



	public String getNewPath() {
		return newpath;
	}



	public FilenameFilter getFilter() {
		return filter;
	}



	public void setFilter(FilenameFilter filter) {
		this.filter = filter;
	}

}
