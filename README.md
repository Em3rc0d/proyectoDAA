Sistema de Gestión de Citas Médicas
Descripción del Proyecto
El Sistema de Gestión de Citas Médicas es una solución integral diseñada para optimizar la administración de citas médicas en un centro de salud peruano. Este sistema permite a los pacientes gestionar sus citas de manera eficiente y proporciona al personal médico una herramienta robusta para manejar la información de los pacientes y sus horarios de manera ordenada y accesible.

Características Principales
Registro de Pacientes: Permite la creación y actualización de perfiles de pacientes con información detallada.
Agendamiento de Citas: Facilita la programación, modificación y cancelación de citas médicas con múltiples especialistas.
Gestión de Médicos: Administra los perfiles de los médicos, incluyendo sus especialidades y horarios disponibles.
Historial Médico: Almacena el historial médico completo de los pacientes, accesible para consultas y seguimiento.
Notificaciones: Envía recordatorios automáticos de citas a los pacientes vía correo electrónico o SMS.
Interfaz Amigable: Diseñada para ser intuitiva tanto para pacientes como para el personal del centro de salud.
Estructura del Proyecto
El proyecto está organizado de la siguiente manera:

src/: Contiene el código fuente del sistema.
pom.xml: Archivo de configuración de Maven para la gestión de dependencias y configuración del proyecto.
nbactions.xml: Configuración específica para el entorno de desarrollo NetBeans.
Tecnologías Utilizadas
Lenguaje de Programación: Java 17
Gestor de Dependencias y Construcción: Maven
Entorno de Desarrollo Integrado (IDE): NetBeans
Requisitos Previos
Antes de instalar y ejecutar el proyecto, asegúrate de tener las siguientes herramientas instaladas:

Java 17: Descargar Java 17
Maven: Descargar Maven
Instalación
Sigue estos pasos para instalar y configurar el proyecto en tu máquina local:

Clonar el repositorio:

bash
Copiar código
git clone https://github.com/Em3rc0d/proyectoDAA.git
Navegar al directorio del proyecto:

bash
Copiar código
cd proyectoDAA
Construir el proyecto con Maven:

bash
Copiar código
mvn clean install
Ejecución del Sistema
Para ejecutar la aplicación, utiliza el siguiente comando de Maven:

bash
Copiar código
mvn exec:java -Dexec.mainClass="proyecto_daa.Paneles.panelInicial"
Contribución
Estamos encantados de recibir contribuciones de la comunidad. Si deseas colaborar, sigue estos pasos:

Realiza un fork del repositorio.
Crea una nueva rama para tu funcionalidad (git checkout -b feature-nueva-funcionalidad).
Realiza tus cambios y haz un commit con un mensaje descriptivo (git commit -am 'Agrega nueva funcionalidad').
Envía tus cambios a tu rama (git push origin feature-nueva-funcionalidad).
Abre un Pull Request en GitHub y describe detalladamente los cambios realizados.
Licencia
Este proyecto está licenciado bajo la Licencia MIT. Para más detalles, consulta el archivo LICENSE.

Integrantes del Proyecto
Integrante: [Merino Cordova, Eduardo Farid]
Integrante: [Poma Alegre, Alvaro Rimbaud]
Integrante: [Ventura Rengifo, Hans Von Kilmer Belizario]
