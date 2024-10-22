document.addEventListener("DOMContentLoaded", function () {
  class Planet {
    constructor(
      name,
      mass,
      radius,
      dayLength,
      yearLength,
      eccentricity,
      axialTilt,
      perihelion,
      aphelion
    ) {
      this.name = name;
      this.mass = mass;
      this.radius = radius;
      this.dayLength = dayLength;
      this.yearLength = yearLength;
      this.eccentricity = eccentricity;
      this.axialTilt = axialTilt;
      this.perihelion = perihelion;
      this.aphelion = aphelion;
    }

    getName() {
      return this.name;
    }
    setName(name) {
      this.name = name;
    }

    getRadius() {
      return this.radius;
    }
    setRadius(radius) {
      this.radius = radius;
    }

    getDayLength() {
      return this.dayLength;
    }
    setDayLength(dayLength) {
      this.dayLength = dayLength;
    }

    getYearLength() {
      return this.yearLength;
    }
    setYearLength(yearLength) {
      this.yearLength = yearLength;
    }

    getEccentricity() {
      return this.eccentricity;
    }
    setEccentricity(eccentricity) {
      this.eccentricity = eccentricity;
    }

    getAxialTilt() {
      return this.axialTilt;
    }
    setAxialTilt(axialTilt) {
      this.axialTilt = axialTilt;
    }

    getPerihelion() {
      return this.perihelion;
    }
    setPerihelion(perihelion) {
      this.perihelion = perihelion;
    }

    getAphelion() {
      return this.aphelion;
    }
    setAphelion(aphelion) {
      this.aphelion = aphelion;
    }
  }

  function renderPlanetInfo(planet, elementId) {
    const planetInfoHtml = `
      ${planet.name}<br>
      ${planet.mass.toExponential().replace(/e\+?/, " x 10^")}<br>
      ${planet.radius}<br>
      ${planet.dayLength.toExponential().replace(/e\+?/, " x 10^")}<br>
      ${planet.yearLength.toExponential().replace(/e\+?/, " x 10^")}<br>
      ${planet.eccentricity}<br>
      ${planet.axialTilt}<br>
      ${planet.perihelion.toExponential().replace(/e\+?/, " x 10^")}<br>
      ${planet.aphelion.toExponential().replace(/e\+?/, " x 10^")}
    `;
    
    document.getElementById(elementId).innerHTML = planetInfoHtml;
  }

  async function planetDataFetch() {
    try {
      const response = await fetch("/api/planets", {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      });
      const planetInfo = await response.json();

      renderPlanetInfo(planetInfo[0], "mercury-planet-information");
      renderPlanetInfo(planetInfo[1], "venus-planet-information");
      renderPlanetInfo(planetInfo[2], "earth-planet-information");
      renderPlanetInfo(planetInfo[3], "mars-planet-information");
      renderPlanetInfo(planetInfo[4], "jupiter-planet-information");
      renderPlanetInfo(planetInfo[5], "saturn-planet-information");
      renderPlanetInfo(planetInfo[6], "uranus-planet-information");
      renderPlanetInfo(planetInfo[7], "neptune-planet-information");
    } catch (error) {
      console.error("Error fetching planet data:", error);
    }
  }
  planetDataFetch();
});
