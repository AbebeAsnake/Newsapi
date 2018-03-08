package me.abebe.demo;

public enum Country {
    AUSTRALIA("au"),
    GERMANY("de"),
    UNITED_KINGDOM("gb"),
    INDIA("in"),
    ITALY("it"),
    UNITED_STATES("us"),
    Argentina("AE"),
    Austria("AT"),
    Belgium("BE");
   /* /// </summary>
    BE,
    BG,
    BR,
    /// <summary>
    /// Canada
    /// </summary>
    CA,
    CH,
    /// <summary>
    /// China
    /// </summary>
    CN,
    CO,
    CU,
    /// <summary>
    /// Czech Republic
    /// </summary>
    CZ,
    /// <summary>
    /// Germany
    /// </summary>
    DE,
    /// <summary>
    /// Egypt
    /// </summary>
    EG,
    /// <summary>
    /// France
    /// </summary>
    FR,
    /// <summary>
    /// United Kingdom
    /// </summary>
    GB,
    /// <summary>
    /// Greece
    /// </summary>
    GR,
    /// <summary>
    /// Hong Kong
    /// </summary>
    HK,
    /// <summary>
    /// Hungary
    /// </summary>
    HU,
    ID,
    /// <summary>
    /// Ireland
    /// </summary>
    IE,
    IL,
    IN,
    /// <summary>
    /// Italy
    /// </summary>
    IT,
    /// <summary>
    /// Japan
    /// </summary>
    JP,
    /// <summary>
    /// South Korea
    /// </summary>
    KR,
    LT,
    LV,
    MA,
    /// <summary>
    /// Mexico
    /// </summary>
    MX,
    MY,
    NG,
    /// <summary>
    /// Netherlands
    /// </summary>
    NL,
    /// <summary>
    /// Norway
    /// </summary>
    NO,
    /// <summary>
    /// New Zealand
    /// </summary>
    NZ,
    PH,
    PL,
    /// <summary>
    /// Portugal
    /// </summary>
    PT,
    RO,
    RS,
    /// <summary>
    /// Russia
    /// </summary>
    RU,
    SA,
    SE,
    SG,
    SI,
    SK,
    TH,
    TR,
    TW,
    UA,
    /// <summary>
    /// United States
    /// </summary>
    US,
    VE,
    ZA*/

    private final String countryCode;

    Country(final String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}