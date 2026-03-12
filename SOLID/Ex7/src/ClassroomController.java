public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        Projector pj = (Projector) reg.getFirstOfType("Projector");
        pj.powerOn();
        pj.connectInput("HDMI-1");

        LightsPanel lights = (LightsPanel) reg.getFirstOfType("LightsPanel");
        lights.setBrightness(60);

        AirConditioner ac = (AirConditioner)reg.getFirstOfType("AirConditioner");
        ac.setTemperatureC(24);

        AttendanceScanner scan = (AttendanceScanner) reg.getFirstOfType("AttendanceScanner");
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        reg.getFirstOfType("Projector").powerOff();
        reg.getFirstOfType("LightsPanel").powerOff();
        reg.getFirstOfType("AirConditioner").powerOff();
    }
}
