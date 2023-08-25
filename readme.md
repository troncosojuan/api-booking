<h1 style="color: #007bff; font-family: Arial, sans-serif;">BookingDigital</h1>

<p>La API BookingDigital es un proyecto FullStack realizado por el grupo 13. Proporciona funcionalidades para gestionar categorías de productos, productos, autenticación y reservas.</p>
<h2>Categoría</h2>
<p>El grupo de categoría tiene un controlador REST que permite realizar operaciones CRUD (crear, leer, actualizar y borrar) en la tabla de categorías.</p>
<h2>Producto</h2>
<p>El grupo de producto tiene un controlador REST con endpoints para crear, borrar, mostrar todos los productos y mostrar un producto por ID.</p>
<h2>Autenticación</h2>
<p>El grupo de autenticación tiene endpoints para registrar usuarios, autenticar usuarios con JWT y gestionar los likes de los productos. También hay un endpoint para mostrar los detalles de un usuario.</p>
<h2>Reservas</h2>
<p>El grupo de reservas tiene endpoints para crear reservas y mostrar las reservas realizadas por un producto.</p>
<p>La API utiliza el esquema de autenticación basado en JWT y filtrado de contraseña para garantizar la seguridad de los datos y la privacidad de los usuarios. Al registrarse o iniciar sesión, la API devuelve un token JWT que se debe incluir en las solicitudes posteriores para autenticar al usuario.</p>
<p>En resumen, la API proporciona una plataforma para gestionar categorías, productos, reservas y usuarios, utilizando una autenticación segura basada en JWT y filtrado de contraseña para garantizar la seguridad de los datos.</p>

<h2>Cómo iniciar la API</h2>
<p>Para iniciar la API, sigue estos pasos:
<ol><li>Clona el repositorio desde GitHub.</li><li>Abre una terminal en la carpeta raíz del proyecto.</li><li>Ejecuta el archivo Pom.xml del proyecto o utiliza el comando <code>mvn spring-boot:run</code> para iniciar la API.</li><li>La API estará disponible localmente con la url <code>http://localhost:8080/</code>.</li></ol>
<h2>Documentación de los endpoints</h2>
<p>Para conocer los detalles y la explicación de los endpoints, consulta el archivo endpoints.xlsx en este <a href="https://docs.google.com/spreadsheets/d/1tIoZ-k31zQxekkK9fOhr7knXlIihDhgjadk9g1uUuWs/edit#gid=0" target="_new">Documentación BookingDigital API</a>.</p>
<h2>Contribuir al proyecto</h2>
<p>Si deseas contribuir al proyecto, por favor genera una solicitud por correo electrónico a <a href="mailto:Troncosojuanbernabe@gmail.com" target="_new">Troncosojuanbernabe@gmail.com</a>. Recuerda que la rama principal es main-back y que las ramas se crean a partir de ella.<p>
<h2>Licencia</h2>
<p>Este proyecto no tiene una licencia registrada.</p>
<h2>Contacto</h2>
<p>Si tienes alguna pregunta o comentario, no dudes en ponerte en contacto con nosotros a través de <a href="mailto:Troncosojuanbernabe@gmail.com" target="_new">Troncosojuanbernabe@gmail.com</a>.</p>

