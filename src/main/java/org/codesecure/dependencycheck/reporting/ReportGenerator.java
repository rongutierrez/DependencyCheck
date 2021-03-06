package org.codesecure.dependencycheck.reporting;
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

import java.io.FileInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.config.EasyFactoryConfiguration;
import org.codesecure.dependencycheck.analyzer.Analyzer;
import org.codesecure.dependencycheck.dependency.Dependency;

/**
 * The ReportGenerator is used to, as the name implies, generate reports. Internally
 * the generator uses the Velocity Templating Engine. The ReportGenerator exposes
 * a list of Dependencies to the template when generating the report.
 *
 * @author Jeremy Long (jeremy.long@gmail.com)
 */
public class ReportGenerator {

    /**
     * The Velocity Engine.
     */
    private VelocityEngine engine = null;
    /**
     * The Velocity Engine Context.
     */
    private Context context = null;

    /**
     * Constructs a new ReportGenerator.
     *
     * @param applicationName the application name being analyzed
     * @param dependencies the list of dependencies
     * @param analyzers the list of analyzers used.
     */
    public ReportGenerator(String applicationName, List<Dependency> dependencies, List<Analyzer> analyzers) {
        engine = createVelocityEngine();
        context = createContext();

        engine.init();

        context.put("applicationName", applicationName);
        context.put("dependencies", dependencies);
        context.put("analyzers", analyzers);
    }

    /**
     * Creates a new Velocity Engine.
     * @return a velocity engine.
     */
    private VelocityEngine createVelocityEngine() {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        return ve;
    }

    /**
     * Creates a new Velocity Context initialized with escape and date tools.
     * @return a Velcotiy Context.
     */
    private Context createContext() {
        ToolManager manager = new ToolManager();
        Context c = manager.createContext();
        EasyFactoryConfiguration config = new EasyFactoryConfiguration();
        config.addDefaultTools();
        config.toolbox("application")
                .tool("esc", "org.apache.velocity.tools.generic.EscapeTool")
                .tool("org.apache.velocity.tools.generic.DateTool");
        manager.configure(config);
        return c;
    }

    /**
     * Generates the Dependency Reports for the identified dependencies.
     *
     * @param outputDir the path where the reports should be written.
     * @throws IOException is thrown when the template file does not exist.
     * @throws Exception is thrown if there is an error writting out the
     * reports.
     */
    public void generateReports(String outputDir) throws IOException, Exception {
        generateReport("HtmlReport", outputDir + File.separator + "DependencyCheck-Report.html");
        //generateReport("XmlReport", outputDir + File.separator + "DependencyCheck-Report.xml");
    }

    /**
     * Generates a report from a given Velocity Template. The template name
     * provided can be the name of a template contained in the jar file, such as
     * 'XmlReport' or 'HtmlReport', or the template name can be the path to a template file.
     *
     * @param templateName the name of the template to load.
     * @param outFileName the filename and path to write the report to.
     * @throws IOException is thrown when the template file does not exist.
     * @throws Exception is thrown when an exception occurs.
     */
    public void generateReport(String templateName, String outFileName) throws IOException, Exception {
        InputStream input = null;
        String templatePath = null;
        File f = new File(templateName);
        if (f.exists() && f.isFile()) {
            try {
                templatePath = templateName;
                input = new FileInputStream(f);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            templatePath = "templates/" + templateName + ".vsl";
            input = this.getClass().getClassLoader().getResourceAsStream(templatePath);
        }
        if (input == null) {
            throw new IOException("Template file doesn't exist");
        }

        InputStreamReader reader = new InputStreamReader(input);
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(new File(outFileName)));

            if (!engine.evaluate(context, writer, templatePath, reader)) {
                throw new Exception("Failed to convert the template into html.");
            }
            writer.flush();
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
                Logger.getLogger(ReportGenerator.class.getName()).log(Level.FINEST, null, ex);
            }
            try {
                reader.close();
            } catch (Exception ex) {
                Logger.getLogger(ReportGenerator.class.getName()).log(Level.FINEST, null, ex);
            }
        }
    }
}
