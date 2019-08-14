{
  "type": "Container",
  "scope": "POI System",
  "description": "The container diagram for the POI System.",
  "size": "A3_Landscape",


  "elements": [
    {
      "type": "Person",
      "name": "Cliente",
      "description": "Dono de um recurso rastreável.",
      "tags": "",
      "position": "1315,2420"
    },
    {
      "type": "Software System",
      "name": "POI System",
      "description": "Permite visualizar o tempo que cada veículo permaneceu nos POIs",
      "tags": "Internal",
      "containers": [
        {
          "type": "Container",
          "name": "Database",
          "description": "Stores geographic objects data.",
          "technology": "PostGIS - PostgreSQL object-relational database",
          "tags": "Database",
          "position": "2570,2630"
        },
        {
          "type": "Container",
          "name": "Single-Page Application",
          "description": "",
          "technology": "JavaScript and Angular",
          "tags": "",
          "position": "1945,2445"
        },
        {
          "type": "Container",
          "name": "Web API",
          "description": "",
          "technology": "Java 8 - Spring Boot",
          "tags": "",
          "position": "2570,2040"
        }
      ]
    }
  ],


  "relationships": [
    {
      "source": "Cliente",
      "description": "Uses",
      "technology": "HTTP",
      "destination": "Single-Page Application",
      "tags": ""
    },
    {
      "source": "Single-Page Application",
      "description": "Uses",
      "technology": "HTTP/JSON",
      "destination": "Web API",
      "tags": ""
    },
    {
      "source": "Web API",
      "description": "Reads from and writes to",
      "technology": "JDBC",
      "destination": "Database",
      "tags": ""
    }
  ],


  "styles": [
    {
      "type": "element",
      "description": "",
      "tag": "Container",
      "width": "",
      "height": "",
      "background": "#438dd5",
      "color": "",
      "fontSize": "",
      "border": "",
      "opacity": "",
      "shape": "",
      "metadata": ""
    },
    {
      "type": "element",
      "description": "",
      "tag": "Database",
      "width": "",
      "height": "",
      "background": "",
      "color": "",
      "fontSize": "",
      "border": "",
      "opacity": "",
      "shape": "Cylinder",
      "metadata": ""
    },
    {
      "type": "element",
      "description": "",
      "tag": "Element",
      "width": "",
      "height": "",
      "background": "",
      "color": "#ffffff",
      "fontSize": "",
      "border": "",
      "opacity": "",
      "shape": "",
      "metadata": ""
    },
    {
      "type": "element",
      "description": "",
      "tag": "Person",
      "width": "",
      "height": "",
      "background": "#08427b",
      "color": "",
      "fontSize": "",
      "border": "",
      "opacity": "",
      "shape": "Person",
      "metadata": ""
    },
    {
      "type": "element",
      "description": "",
      "tag": "Software System",
      "width": "",
      "height": "",
      "background": "#1168bd",
      "color": "",
      "fontSize": "",
      "border": "",
      "opacity": "",
      "shape": "",
      "metadata": ""
    }
  ]
}