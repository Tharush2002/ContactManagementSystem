# iFRIENDS Contact Management System

This project is a Java Swing-based GUI application that manages contacts for the iFRIENDS Contact Management System. Users can add, update, search, delete, and view contacts through an intuitive graphical interface.

## Features

1. **Home Page**: A central interface to navigate to different functionalities like Add, Update, Search, Delete, and View Contacts.
2. **Add New Contacts**:
   - Users can add a new contact by entering details such as Name, Contact Number, Company, Salary, and Birthday.
   - The system validates the Contact Number for format and uniqueness.
   - Automatically generates a unique Contact ID.
   - Includes options to clear fields and return to the Home Page.
3. **Update Contacts**:
   - Users can update existing contact details.
   - Search for a contact using Name or Contact Number, and update the displayed details.
4. **Search Contacts**:
   - Search for a contact by Name or Contact Number.
   - Displays the complete details of the contact.
5. **Delete Contacts**:
   - Locate a contact by Name or Contact Number and delete it.
6. **View Contacts**:
   - View all contacts.
   - Sort contacts by Name or Salary.

## Usage

- **Home Page**: Navigation interface to access all features.
- **Add Contact**: Form to enter new contact details.
- **Update Contact**: Interface to modify existing contact information.
- **Search Contact**: Search and view contact details.
- **Delete Contact**: Locate and remove contacts.
- **View Contacts**: Display a sortable list of contacts.

## Technologies Used

- **Programming Language**: Java
- **IDE**: NetBeans (Recommended for running the project)
- **GUI Framework**: Java Swing

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Tharush2002/ContactManagementSystem.git
   ```
2. **Open in NetBeans**:
   - Launch NetBeans IDE.
   - Navigate to `File -> Open Project` and select the cloned repository.
3. **Run the Application**:
   - Start the application by running the `ContactOrganizerHomePage.java` file, which contains the `main` method.

## Usage

1. **Launch the Application**:
   - Open the project in NetBeans.
   - Run `ContactOrganizerHomePage.java` to open the Home Page.
2. **Navigate Through Features**:
   - Use buttons on the Home Page to access different functionalities:
     - Add Contact
     - Update Contact
     - Search Contact
     - Delete Contact
     - View Contacts
3. **Perform Actions**:
   - Follow the prompts in each interface to perform the desired actions.

## Validations and Constraints

- **Contact Number**:
  - Must start with `0`.
  - Must have exactly 10 digits.
- **Contact ID**:
  - Automatically generated based on the last Contact ID.
  - Ensures uniqueness.

## Real-World Applications

This project is a scalable and modular contact management system that can be used by individuals or organizations to efficiently manage contact information. The GUI makes it user-friendly and accessible to non-technical users.

## Contribution

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`feature/your-feature-name`).
3. Commit your changes.
4. Submit a pull request.

For any issues or suggestions, feel free to open an issue or contact me.
