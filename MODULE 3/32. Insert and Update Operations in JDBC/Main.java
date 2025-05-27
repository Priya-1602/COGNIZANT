public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        boolean inserted = dao.insertStudent(6, "Priya", 21);
        System.out.println(inserted ? "Student inserted successfully." : "Insert failed.");
        boolean updated = dao.updateStudent(7, "Priya Sharma", 22);
        System.out.println(updated ? "Student updated successfully." : "Update failed.");
    }
}

