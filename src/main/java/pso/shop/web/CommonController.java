package pso.shop.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.net.InetAddress;
import java.net.UnknownHostException;

@ControllerAdvice
public class CommonController {

    private final String machineIp;
    private final String machineHostName;

    public CommonController() {
        String ip = "";
        String hostname = "";
        try {
            InetAddress localInet = InetAddress.getLocalHost();
            ip = localInet.getHostAddress();
            hostname = localInet.getHostName();
        } catch (UnknownHostException e) {
            //Ignoring
        }
        this.machineIp = ip;
        this.machineHostName = hostname;

    }

    @ModelAttribute
    public void modelAttributes(Model model) {
        model.addAttribute("machineIp", machineIp);
        model.addAttribute("machineHostName", machineHostName);
    }


}
