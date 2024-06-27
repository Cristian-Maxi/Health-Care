const Emociones = [
  {
    "id": 1,
    "fechaCreacion": "2024-06-02T06:15:49.466Z",
    "descripcion": "Me siento abrumado por la situación familiar.",
    "tipoEmocion": "MUY_MAL",
    "paciente": {
      "id": 1,
      "nombre": "Juan",
      "apellido": "González",
      "email": "juan.gonzalez@example.com",
      "telefono": "+1234567890"
    }
  },
  {
    "id": 2,
    "fechaCreacion": "2024-05-19T06:15:49.466Z",
    "descripcion": "Estoy preocupado por el futuro laboral.",
    "tipoEmocion": "MAL",
    "paciente": {
      "id": 2,
      "nombre": "María",
      "apellido": "López",
      "email": "maria.lopez@example.com",
      "telefono": "+1987654321"
    }
  },
  {
    "id": 3,
    "fechaCreacion": "2024-06-13T06:15:49.466Z",
    "descripcion": "Me siento tranquilo después de un día ocupado.",
    "tipoEmocion": "NORMAL",
    "paciente": {
      "id": 3,
      "nombre": "Pedro",
      "apellido": "Martínez",
      "email": "pedro.martinez@example.com",
      "telefono": "+1122334455"
    }
  },
  {
    "id": 4,
    "fechaCreacion": "2024-06-13T06:15:49.466Z",
    "descripcion": "Disfruté de una buena comida con amigos.",
    "tipoEmocion": "BIEN",
    "paciente": {
      "id": 4,
      "nombre": "Ana",
      "apellido": "Sánchez",
      "email": "ana.sanchez@example.com",
      "telefono": "+1555666777"
    }
  },
  {
    "id": 5,
    "fechaCreacion": "2024-06-13T06:15:49.466Z",
    "descripcion": "Me siento emocionado por el próximo viaje planeado.",
    "tipoEmocion": "MUY_BIEN",
    "paciente": {
      "id": 5,
      "nombre": "Carlos",
      "apellido": "Gómez",
      "email": "carlos.gomez@example.com",
      "telefono": "+1444333222"
    }
  },
  {
    "id": 6,
    "fechaCreacion": "2024-06-13T06:15:49.466Z",
    "descripcion": "Siento una profunda tristeza por la pérdida de mi mascota.",
    "tipoEmocion": "MUY_MAL",
    "paciente": {
      "id": 6,
      "nombre": "Laura",
      "apellido": "Pérez",
      "email": "laura.perez@example.com",
      "telefono": "+1999888777"
    }
  },
  {
    "id": 7,
    "fechaCreacion": "2024-06-13T06:15:49.466Z",
    "descripcion": "Estoy frustrado por no poder resolver este problema técnico.",
    "tipoEmocion": "MAL",
    "paciente": {
      "id": 7,
      "nombre": "Jorge",
      "apellido": "Ramírez",
      "email": "jorge.ramirez@example.com",
      "telefono": "+1666777888"
    }
  },
  {
    "id": 8,
    "fechaCreacion": "2024-06-13T06:15:49.466Z",
    "descripcion": "Me siento contento por haber terminado un proyecto.",
    "tipoEmocion": "NORMAL",
    "paciente": {
      "id": 8,
      "nombre": "Elena",
      "apellido": "Díaz",
      "email": "elena.diaz@example.com",
      "telefono": "+1888999000"
    }
  },
  {
    "id": 9,
    "fechaCreacion": "2024-07-17T06:15:49.466Z",
    "descripcion": "Disfruté de una buena sesión de ejercicio.",
    "tipoEmocion": "BIEN",
    "paciente": {
      "id": 9,
      "nombre": "Pablo",
      "apellido": "Torres",
      "email": "pablo.torres@example.com",
      "telefono": "+1777666555"
    }
  },
  {
    "id": 10,
    "fechaCreacion": "2024-02-12T06:15:49.466Z",
    "descripcion": "Me siento feliz por el éxito de un ser querido.",
    "tipoEmocion": "MUY_BIEN",
    "paciente": {
      "id": 10,
      "nombre": "Lucía",
      "apellido": "Fernández",
      "email": "lucia.fernandez@example.com",
      "telefono": "+1666555444"
    }
  },
  {
    "id": 11,
    "fechaCreacion": "2024-06-23T06:15:49.466Z",
    "descripcion": "Me siento cansado después de una semana agitada.",
    "tipoEmocion": "MAL",
    "paciente": {
      "id": 1,
      "nombre": "Juan",
      "apellido": "González",
      "email": "juan.gonzalez@example.com",
      "telefono": "+1234567890"
    }
  },
  {
    "id": 12,
    "fechaCreacion": "2024-05-22T08:30:00.000Z",
    "descripcion": "Me siento nervioso antes de una presentación importante.",
    "tipoEmocion": "MAL",
    "paciente": {
      "id": 1,
      "nombre": "Juan",
      "apellido": "González",
      "email": "juan.gonzalez@example.com",
      "telefono": "+1234567890"
    }
  },
  {
    "id": 13,
    "fechaCreacion": "2024-04-13T10:45:00.000Z",
    "descripcion": "Estoy emocionado por comenzar un nuevo proyecto creativo.",
    "tipoEmocion": "MUY_BIEN",
    "paciente": {
      "id": 1,
      "nombre": "Juan",
      "apellido": "González",
      "email": "juan.gonzalez@example.com",
      "telefono": "+1234567890"
    }
  },
  {
    "id": 14,
    "fechaCreacion": "2024-04-02T13:20:00.000Z",
    "descripcion": "Me siento aliviado después de una conversación difícil.",
    "tipoEmocion": "BIEN",
    "paciente": {
      "id": 1,
      "nombre": "Juan",
      "apellido": "González",
      "email": "juan.gonzalez@example.com",
      "telefono": "+1234567890"
    }
  },
  {
    "id": 15,
    "fechaCreacion": "2024-02-18T15:00:00.000Z",
    "descripcion": "Me siento agobiado por las responsabilidades familiares.",
    "tipoEmocion": "MAL",
    "paciente": {
      "id": 1,
      "nombre": "Juan",
      "apellido": "González",
      "email": "juan.gonzalez@example.com",
      "telefono": "+1234567890"
    }
  },
  {
    "id": 16,
    "fechaCreacion": "2024-01-15T17:10:00.000Z",
    "descripcion": "Disfruté de una cena relajada con mi pareja.",
    "tipoEmocion": "BIEN",
    "paciente": {
      "id": 1,
      "nombre": "Juan",
      "apellido": "González",
      "email": "juan.gonzalez@example.com",
      "telefono": "+1234567890"
    }
  }
];

export default Emociones;
