public class AttendanceScanner implements SmartClassroomDevice, AttendanceScannable {
    @Override public void powerOn() { /* ok */ }
    @Override public void powerOff() { /* no output */ }
    @Override public int scanAttendance() { return 3; }
}
