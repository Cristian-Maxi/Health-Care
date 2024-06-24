const DataPsicologos = [
    {
        "id": 1,
        "nombre": "Carlos",
        "apellido": "Suarez",
        "email": "carlos@gmail.com",
        "telefono": "47658945",
        "documento": "25987456",
        "descripcion": "Carlos Suárez es un psicólogo con más de 10 años de experiencia en terapia cognitivo-conductual, especializado en el tratamiento de la ansiedad y la depresión. Su enfoque se basa en técnicas prácticas para cambiar patrones de pensamiento negativos.",
        "rol": "PSICOLOGO",
        "valoracion": 3,
        "especialidad": "PSICOLOGÍA_COGNITIVO_CONDUCTUAL"
    },
    {
        "id": 2,
        "nombre": "Marta",
        "apellido": "Perez",
        "email": "marta@gmail.com",
        "telefono": "123456",
        "documento": "22568987",
        "descripcion": "Marta Pérez se destaca por su enfoque en la terapia cognitivo-conductual, ayudando a sus pacientes a desarrollar habilidades para manejar el estrés y mejorar su bienestar emocional. Tiene una amplia experiencia en trabajar con adolescentes.",
        "rol": "PSICOLOGO",
        "valoracion": 3,
        "especialidad": "PSICOLOGÍA_COGNITIVO_CONDUCTUAL"
    },
    {
        "id": 3,
        "nombre": "Ana",
        "apellido": "García",
        "email": "ana@gmail.com",
        "telefono": "78912345",
        "documento": "30987654",
        "descripcion": "Ana García es una psicóloga humanista que cree en el potencial inherente de cada individuo. Con una trayectoria de 15 años, se dedica a fomentar el crecimiento personal y la autorrealización en sus pacientes.",
        "rol": "PSICOLOGO",
        "valoracion": 4,
        "especialidad": "PSICOLOGÍA_HUMANISTA"
    },
    {
        "id": 4,
        "nombre": "Luis",
        "apellido": "Martínez",
        "email": "luis@gmail.com",
        "telefono": "45678912",
        "documento": "31897564",
        "descripcion": "Luis Martínez es un psicólogo clínico con una vasta experiencia en el tratamiento de trastornos mentales graves. Su trabajo se centra en la evaluación y el tratamiento de pacientes con condiciones como el trastorno bipolar y la esquizofrenia.",
        "rol": "PSICOLOGO",
        "valoracion": 5,
        "especialidad": "PSICOLOGÍA_PSICOANALÍTICA"
    },
    {
        "id": 5,
        "nombre": "Elena",
        "apellido": "López",
        "email": "elena@gmail.com",
        "telefono": "32165487",
        "documento": "27658934",
        "descripcion": "Elena López es una psicóloga infantil apasionada por ayudar a los niños a superar dificultades emocionales y de comportamiento. Utiliza un enfoque lúdico y creativo para conectar con sus jóvenes pacientes y promover su desarrollo saludable.",
        "rol": "PSICOLOGO",
        "valoracion": 4,
        "especialidad": "TERAPIA_FAMILIAR_Y_SISTÉMICA"
    },
    {
        "id": 6,
        "nombre": "Miguel",
        "apellido": "Sánchez",
        "email": "miguel@gmail.com",
        "telefono": "98765432",
        "documento": "34587621",
        "descripcion": "Miguel Sánchez es un psicólogo especializado en la psicología de la salud, dedicado a mejorar la calidad de vida de sus pacientes mediante la promoción de hábitos saludables y el manejo del estrés. Trabaja tanto con individuos como con grupos.",
        "rol": "PSICOLOGO",
        "valoracion": 3,
        "especialidad": "MINDFULNESS_Y_TERAPIAS_BASADAS_EN_LA_ATENCIÓN_PLENA"
    },
    {
        "id": 7,
        "nombre": "Laura",
        "apellido": "Fernández",
        "email": "laura@gmail.com",
        "telefono": "65498732",
        "documento": "29765438",
        "descripcion": "Laura Fernández es una psicóloga forense con experiencia en la evaluación de la credibilidad de testimonios y la preparación de informes periciales. Su trabajo contribuye a la justicia en casos legales complejos.",
        "rol": "PSICOLOGO",
        "valoracion": 5,
        "especialidad": "PSICOLOGÍA_COGNITIVO_CONDUCTUAL"
    },
    {
        "id": 8,
        "nombre": "Javier",
        "apellido": "Gómez",
        "email": "javier@gmail.com",
        "telefono": "74185296",
        "documento": "31659874",
        "descripcion": "Javier Gómez es un psicólogo deportivo que ayuda a los atletas a alcanzar su máximo rendimiento mediante el fortalecimiento de su mentalidad y el desarrollo de estrategias para manejar la presión competitiva.",
        "rol": "PSICOLOGO",
        "valoracion": 4,
        "especialidad": "PSICOLOGÍA_GESTALT"
    },
    {
        "id": 9,
        "nombre": "Patricia",
        "apellido": "Rodríguez",
        "email": "patricia@gmail.com",
        "telefono": "15948726",
        "documento": "28576194",
        "descripcion": "Patricia Rodríguez es una psicóloga ocupacional que se especializa en mejorar el bienestar y la productividad en el lugar de trabajo. Su enfoque incluye la gestión del estrés laboral y la promoción de un entorno de trabajo saludable.",
        "rol": "PSICOLOGO",
        "valoracion": 4,
        "especialidad": "PSICOLOGÍA_HUMANISTA"
    },
    {
        "id": 10,
        "nombre": "Roberto",
        "apellido": "Ruiz",
        "email": "roberto@gmail.com",
        "telefono": "96325874",
        "documento": "29856314",
        "descripcion": "Roberto Ruiz es un psicólogo familiar con una sólida experiencia en la mediación de conflictos y la terapia de familia. Trabaja para fortalecer las relaciones familiares y promover una comunicación efectiva entre sus miembros.",
        "rol": "PSICOLOGO",
        "valoracion": 5,
        "especialidad": "TERAPIA_FAMILIAR_Y_SISTÉMICA"
    },
    {
        "id": 11,
        "nombre": "Sonia",
        "apellido": "Hernández",
        "email": "sonia@gmail.com",
        "telefono": "85236974",
        "documento": "32587469",
        "descripcion": "Sonia Hernández es una psicóloga educativa que trabaja con estudiantes para mejorar su rendimiento académico y su bienestar emocional. Utiliza estrategias de intervención temprana para abordar dificultades de aprendizaje y problemas de conducta.",
        "rol": "PSICOLOGO",
        "valoracion": 3,
        "especialidad": "PSICOLOGÍA_HUMANISTA"
    },
    {
        "id": 12,
        "nombre": "Raúl",
        "apellido": "Torres",
        "email": "raul@gmail.com",
        "telefono": "78945612",
        "documento": "34982561",
        "descripcion": "Raúl Torres es un psicólogo especializado en la psicología cognitiva, enfocado en el estudio de los procesos mentales como la memoria, el aprendizaje y la percepción. Aplica sus conocimientos para ayudar a sus pacientes a mejorar sus habilidades cognitivas.",
        "rol": "PSICOLOGO",
        "valoracion": 4,
        "especialidad": "MINDFULNESS_Y_TERAPIAS_BASADAS_EN_LA_ATENCIÓN_PLENA"
    }
]

export default DataPsicologos;

// const DataPsicologos=[
//     {
//         "id": 1,
//         "nombre": "Carlos",
//         "apellido": "Suarez",
//         "email": "carlos@gmail.com",
//         "telefono": "47658945",
//         "documento": "25987456",
//         "descripcion": "Carlos Suárez es un psicólogo con más de 10 años de experiencia en terapia cognitivo-conductual, especializado en el tratamiento de la ansiedad y la depresión. Su enfoque se basa en técnicas prácticas para cambiar patrones de pensamiento negativos.",
//         "rol": "PSICOLOGO",
//         "valoracion": 3,
//         "especialidad": "PSICOLOGÍA_COGNITIVO_CONDUCTUAL"
//     },
//     {
//         "id": 2,
//         "nombre": "Marta",
//         "apellido": "Perez",
//         "email": "marta@gmail.com",
//         "telefono": "123456",
//         "documento": "22568987",
//         "descripcion": "Marta Pérez se destaca por su enfoque en la terapia cognitivo-conductual, ayudando a sus pacientes a desarrollar habilidades para manejar el estrés y mejorar su bienestar emocional. Tiene una amplia experiencia en trabajar con adolescentes.",
//         "rol": "PSICOLOGO",
//         "valoracion": 3,
//         "especialidad": "PSICOLOGÍA_COGNITIVO_CONDUCTUAL"
//     },
//     {
//         "id": 3,
//         "nombre": "Ana",
//         "apellido": "García",
//         "email": "ana@gmail.com",
//         "telefono": "78912345",
//         "documento": "30987654",
//         "descripcion": "Ana García es una psicóloga humanista que cree en el potencial inherente de cada individuo. Con una trayectoria de 15 años, se dedica a fomentar el crecimiento personal y la autorrealización en sus pacientes.",
//         "rol": "PSICOLOGO",
//         "valoracion": 4,
//         "especialidad": "PSICOLOGÍA_HUMANISTA"
//     },
//     {
//         "id": 4,
//         "nombre": "Luis",
//         "apellido": "Martínez",
//         "email": "luis@gmail.com",
//         "telefono": "45678912",
//         "documento": "31897564",
//         "descripcion": "Luis Martínez es un psicólogo clínico con una vasta experiencia en el tratamiento de trastornos mentales graves. Su trabajo se centra en la evaluación y el tratamiento de pacientes con condiciones como el trastorno bipolar y la esquizofrenia.",
//         "rol": "PSICOLOGO",
//         "valoracion": 5,
//         "especialidad": "PSICOLOGÍA_CLÍNICA"
//     },
//     {
//         "id": 5,
//         "nombre": "Elena",
//         "apellido": "López",
//         "email": "elena@gmail.com",
//         "telefono": "32165487",
//         "documento": "27658934",
//         "descripcion": "Elena López es una psicóloga infantil apasionada por ayudar a los niños a superar dificultades emocionales y de comportamiento. Utiliza un enfoque lúdico y creativo para conectar con sus jóvenes pacientes y promover su desarrollo saludable.",
//         "rol": "PSICOLOGO",
//         "valoracion": 4,
//         "especialidad": "PSICOLOGÍA_INFANTIL"
//     },
//     {
//         "id": 6,
//         "nombre": "Miguel",
//         "apellido": "Sánchez",
//         "email": "miguel@gmail.com",
//         "telefono": "98765432",
//         "documento": "34587621",
//         "descripcion": "Miguel Sánchez es un psicólogo especializado en la psicología de la salud, dedicado a mejorar la calidad de vida de sus pacientes mediante la promoción de hábitos saludables y el manejo del estrés. Trabaja tanto con individuos como con grupos.",
//         "rol": "PSICOLOGO",
//         "valoracion": 3,
//         "especialidad": "PSICOLOGÍA_DE_LA_SALUD"
//     },
//     {
//         "id": 7,
//         "nombre": "Laura",
//         "apellido": "Fernández",
//         "email": "laura@gmail.com",
//         "telefono": "65498732",
//         "documento": "29765438",
//         "descripcion": "Laura Fernández es una psicóloga forense con experiencia en la evaluación de la credibilidad de testimonios y la preparación de informes periciales. Su trabajo contribuye a la justicia en casos legales complejos.",
//         "rol": "PSICOLOGO",
//         "valoracion": 5,
//         "especialidad": "PSICOLOGÍA_FORENSE"
//     },
//     {
//         "id": 8,
//         "nombre": "Javier",
//         "apellido": "Gómez",
//         "email": "javier@gmail.com",
//         "telefono": "74185296",
//         "documento": "31659874",
//         "descripcion": "Javier Gómez es un psicólogo deportivo que ayuda a los atletas a alcanzar su máximo rendimiento mediante el fortalecimiento de su mentalidad y el desarrollo de estrategias para manejar la presión competitiva.",
//         "rol": "PSICOLOGO",
//         "valoracion": 4,
//         "especialidad": "PSICOLOGÍA_DEPORTIVA"
//     },
//     {
//         "id": 9,
//         "nombre": "Patricia",
//         "apellido": "Rodríguez",
//         "email": "patricia@gmail.com",
//         "telefono": "15948726",
//         "documento": "28576194",
//         "descripcion": "Patricia Rodríguez es una psicóloga ocupacional que se especializa en mejorar el bienestar y la productividad en el lugar de trabajo. Su enfoque incluye la gestión del estrés laboral y la promoción de un entorno de trabajo saludable.",
//         "rol": "PSICOLOGO",
//         "valoracion": 4,
//         "especialidad": "PSICOLOGÍA_OCUPACIONAL"
//     },
//     {
//         "id": 10,
//         "nombre": "Roberto",
//         "apellido": "Ruiz",
//         "email": "roberto@gmail.com",
//         "telefono": "96325874",
//         "documento": "29856314",
//         "descripcion": "Roberto Ruiz es un psicólogo familiar con una sólida experiencia en la mediación de conflictos y la terapia de familia. Trabaja para fortalecer las relaciones familiares y promover una comunicación efectiva entre sus miembros.",
//         "rol": "PSICOLOGO",
//         "valoracion": 5,
//         "especialidad": "PSICOLOGÍA_FAMILIAR"
//     },
//     {
//         "id": 11,
//         "nombre": "Sonia",
//         "apellido": "Hernández",
//         "email": "sonia@gmail.com",
//         "telefono": "85236974",
//         "documento": "32587469",
//         "descripcion": "Sonia Hernández es una psicóloga educativa que trabaja con estudiantes para mejorar su rendimiento académico y su bienestar emocional. Utiliza estrategias de intervención temprana para abordar dificultades de aprendizaje y problemas de conducta.",
//         "rol": "PSICOLOGO",
//         "valoracion": 3,
//         "especialidad": "PSICOLOGÍA_EDUCATIVA"
//     },
//     {
//         "id": 12,
//         "nombre": "Raúl",
//         "apellido": "Torres",
//         "email": "raul@gmail.com",
//         "telefono": "78945612",
//         "documento": "34982561",
//         "descripcion": "Raúl Torres es un psicólogo especializado en la psicología cognitiva, enfocado en el estudio de los procesos mentales como la memoria, el aprendizaje y la percepción. Aplica sus conocimientos para ayudar a sus pacientes a mejorar sus habilidades cognitivas.",
//         "rol": "PSICOLOGO",
//         "valoracion": 4,
//         "especialidad": "PSICOLOGÍA_COGNITIVA"
//     }
// ]

// export default DataPsicologos