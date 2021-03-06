package org.codesecure.dependencycheck.analyzer;
/*
 * This file is part of DependencyCheck.
 *
 * DependencyCheck is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * DependencyCheck is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * DependencyCheck. If not, see http://www.gnu.org/licenses/.
 *
 * Copyright (c) 2012 Jeremy Long. All Rights Reserved.
 */

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jeremy Long (jeremy.long@gmail.com)
 */
public abstract class AbstractAnalyzer implements Analyzer {

    /**
     * Utility method to help in the creation of the extensions set. This constructs
     * a new Set that can be used in a final static declaration.<br/><br/>
     *
     * This implementation was copied from http://stackoverflow.com/questions/2041778/initialize-java-hashset-values-by-construction
     *
     * @param strings a list of strings to add to the set.
     * @return a Set of strings.
     */
    protected static Set<String> newHashSet(String... strings) {
        Set<String> set = new HashSet<String>();

        //yes, in Java7 we could use Array.toList(...) - but I'm trying to keep this Java 6 compliant.
        for (String s : strings) {
            set.add(s);
        }
        return set;
    }
}
