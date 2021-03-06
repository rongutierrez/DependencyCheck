package org.codesecure.dependencycheck.data.nvdcve.generated;
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

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2012.10.21 at 11:58:46 AM EDT
//
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for environmentalMetricsType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained
 * within this class.
 *
 * <pre>
 * &lt;complexType name="environmentalMetricsType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://scap.nist.gov/schema/cvss-v2/0.2}metricsType">
 *       &lt;sequence>
 *         &lt;element name="score" type="{http://scap.nist.gov/schema/cvss-v2/0.2}zeroToTenDecimalType" minOccurs="0"/>
 *         &lt;group ref="{http://scap.nist.gov/schema/cvss-v2/0.2}environmentalVectorsGroup"/>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="generated-on-datetime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "environmentalMetricsType", propOrder = {
    "score",
    "collateralDamagePotential",
    "targetDistribution",
    "confidentialityRequirement",
    "integrityRequirement",
    "availabilityRequirement",
    "source",
    "generatedOnDatetime"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class EnvironmentalMetricsType
        extends MetricsType {

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected BigDecimal score;
    @XmlElement(name = "collateral-damage-potential")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected CollateralDamagePotentialType collateralDamagePotential;
    @XmlElement(name = "target-distribution")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected TargetDistributionType targetDistribution;
    @XmlElement(name = "confidentiality-requirement")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected CiaRequirementType confidentialityRequirement;
    @XmlElement(name = "integrity-requirement")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected CiaRequirementType integrityRequirement;
    @XmlElement(name = "availability-requirement")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected CiaRequirementType availabilityRequirement;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String source;
    @XmlElement(name = "generated-on-datetime")
    @XmlSchemaType(name = "dateTime")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected XMLGregorianCalendar generatedOnDatetime;

    /**
     * Gets the value of the score property.
     *
     * @return possible object is
     *     {@link BigDecimal }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public BigDecimal getScore() {
        return score;
    }

    /**
     * Sets the value of the score property.
     *
     * @param value allowed object is
     *     {@link BigDecimal }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setScore(BigDecimal value) {
        this.score = value;
    }

    /**
     * Gets the value of the collateralDamagePotential property.
     *
     * @return possible object is
     *     {@link CollateralDamagePotentialType }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public CollateralDamagePotentialType getCollateralDamagePotential() {
        return collateralDamagePotential;
    }

    /**
     * Sets the value of the collateralDamagePotential property.
     *
     * @param value allowed object is
     *     {@link CollateralDamagePotentialType }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setCollateralDamagePotential(CollateralDamagePotentialType value) {
        this.collateralDamagePotential = value;
    }

    /**
     * Gets the value of the targetDistribution property.
     *
     * @return possible object is
     *     {@link TargetDistributionType }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public TargetDistributionType getTargetDistribution() {
        return targetDistribution;
    }

    /**
     * Sets the value of the targetDistribution property.
     *
     * @param value allowed object is
     *     {@link TargetDistributionType }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setTargetDistribution(TargetDistributionType value) {
        this.targetDistribution = value;
    }

    /**
     * Gets the value of the confidentialityRequirement property.
     *
     * @return possible object is
     *     {@link CiaRequirementType }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public CiaRequirementType getConfidentialityRequirement() {
        return confidentialityRequirement;
    }

    /**
     * Sets the value of the confidentialityRequirement property.
     *
     * @param value allowed object is
     *     {@link CiaRequirementType }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setConfidentialityRequirement(CiaRequirementType value) {
        this.confidentialityRequirement = value;
    }

    /**
     * Gets the value of the integrityRequirement property.
     *
     * @return possible object is
     *     {@link CiaRequirementType }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public CiaRequirementType getIntegrityRequirement() {
        return integrityRequirement;
    }

    /**
     * Sets the value of the integrityRequirement property.
     *
     * @param value allowed object is
     *     {@link CiaRequirementType }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setIntegrityRequirement(CiaRequirementType value) {
        this.integrityRequirement = value;
    }

    /**
     * Gets the value of the availabilityRequirement property.
     *
     * @return possible object is
     *     {@link CiaRequirementType }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public CiaRequirementType getAvailabilityRequirement() {
        return availabilityRequirement;
    }

    /**
     * Sets the value of the availabilityRequirement property.
     *
     * @param value allowed object is
     *     {@link CiaRequirementType }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setAvailabilityRequirement(CiaRequirementType value) {
        this.availabilityRequirement = value;
    }

    /**
     * Gets the value of the source property.
     *
     * @return possible object is
     *     {@link String }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     *
     * @param value allowed object is
     *     {@link String }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the generatedOnDatetime property.
     *
     * @return possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public XMLGregorianCalendar getGeneratedOnDatetime() {
        return generatedOnDatetime;
    }

    /**
     * Sets the value of the generatedOnDatetime property.
     *
     * @param value allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-10-21T11:58:46-04:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setGeneratedOnDatetime(XMLGregorianCalendar value) {
        this.generatedOnDatetime = value;
    }
}
