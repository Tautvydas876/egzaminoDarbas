package com.example.EgzaminoDarbas.controller;


import com.example.EgzaminoDarbas.entity.Istaiga;
import com.example.EgzaminoDarbas.entity.Patiekalas;
import com.example.EgzaminoDarbas.entity.User;
import com.example.EgzaminoDarbas.entity.Valgiarastis;
import com.example.EgzaminoDarbas.service.IstaigaService;
import com.example.EgzaminoDarbas.service.PatiekalasService;
import com.example.EgzaminoDarbas.service.UserService;
import com.example.EgzaminoDarbas.service.ValgiarastisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {


    @Autowired
    IstaigaService istaigaService;
    @Autowired
    ValgiarastisService valgiarastisService;
    @Autowired
    UserService userService;
    @Autowired
    PatiekalasService patiekalasService;

    public UserController(IstaigaService istaigaService, ValgiarastisService valgiarastisService, UserService userService, PatiekalasService patiekalasService) {
        this.istaigaService = istaigaService;
        this.valgiarastisService = valgiarastisService;
        this.userService = userService;
        this.patiekalasService = patiekalasService;
    }

    @PostMapping("/login")
    public String loginForm(@RequestParam("username") String username, @RequestParam("password") String password,
                            Model model) {
        User user = userService.findUserFromDB(username, password);

        if (user.getAdmin()) {
            model.addAttribute("admin", user);
            return "redirect:/admin-page";
        } else {
            model.addAttribute("user", user);
            return "redirect:/user-page";
        }
    }

//    ==== ADMIN - PAGE ====

    @PostMapping("/admin-page/addIstaiga")
    public String addIstaiga(@RequestParam("name") String name, @RequestParam("code") int code,
                             @RequestParam("address") String address, Model model) {

        Istaiga istaiga = new Istaiga(name, code, address);
        istaigaService.save(istaiga);
        return "redirect:/admin-page";
    }

    @PostMapping("/admin-page/addValgiarastis")
    public String addValgiarastis(@RequestParam("name") String name, @RequestParam("ist_name") String istName) {
        Valgiarastis valgiarastis = new Valgiarastis(name);

        Istaiga istaiga = istaigaService.findByName(istName);
        valgiarastis.setIstaiga(istaiga);

        valgiarastisService.save(valgiarastis);
        return "redirect:/admin-page";
    }


    @PostMapping("/admin-page/updateValgiarastis")
    public String updateVagiarastis(@RequestParam("val_id") int id, @RequestParam("name") String name,
                                    @RequestParam("ist_name") String istName) {
        Istaiga istaiga = istaigaService.findByName(istName);

        Valgiarastis valgiarastis = new Valgiarastis(id, name);
        valgiarastis.setIstaiga(istaiga);

        valgiarastisService.save(valgiarastis);
        return "redirect:/admin-page";
    }

    @PostMapping("/admin-page/deleteValgiarastis")
    public String deleteValgiarastis(@RequestParam("valgiarastis_id") int id) {
        valgiarastisService.deleteById(id);
        return "redirect:/admin-page";
    }

    @PostMapping("/admin-page/updateIstaiga")
    public String updateIstaiga(@RequestParam("ist_id") int id, @RequestParam("name") String name,
                                @RequestParam("code") int code, @RequestParam("address") String address) {
        Istaiga istaiga = new Istaiga(id, name, code, address);
        istaigaService.save(istaiga);
        return "redirect:/admin-page";
    }

    @PostMapping("/admin-page/addPatiekalas")
    public String addPatiekalas(@RequestParam("val_name") String valName, @RequestParam("pat_name") String patName,
                                @RequestParam("summary") String summary, Model model) {

        Valgiarastis valgiarastis = valgiarastisService.findByName(valName);
        Patiekalas patiekalas = new Patiekalas(patName, summary);

        patiekalas.setValgiarastis(valgiarastis);

        patiekalasService.save(patiekalas);
        return "redirect:/admin-page";
    }

    @PostMapping("/admin-page/deletePatiekalas")
    public String deletePatiekalas(@RequestParam("pat_id") int id) {
        patiekalasService.deleteById(id);
        return "redirect:/admin-page";
    }

    @PostMapping("/admin-page/updatePatiekalas")
    public String updatePatiekalas(@RequestParam("pat_id") int patID, @RequestParam("pat_name") String patName,
                                   @RequestParam("summary") String summary, @RequestParam("val_name") String valName) {
        Patiekalas patiekalas = new Patiekalas(patID, patName, summary);
        Valgiarastis valgiarastis = valgiarastisService.findByName(valName);

        patiekalas.setValgiarastis(valgiarastis);
        patiekalasService.save(patiekalas);
        return "redirect:/admin-page";
    }

//    === USER - Page ===

    @GetMapping("/user-page/selectIstaiga")
    public String selectValgiarasty(@RequestParam("ist_name") String name, Model model) {
        Istaiga istaiga = istaigaService.findByName(name);
        model.addAttribute("valgiarastis", valgiarastisService.findAllByIstaigosId(istaiga.getId()));
        System.out.println(istaiga);
        return "redirect:/user-page";
    }

//    ============= Forms ==========

    @GetMapping("/")
    public String ShowLoginForm() {
        return "/login";
    }

    @GetMapping("/admin-page")
    public String showAdminPage(Model model) {

        model.addAttribute("istaiga", istaigaService.findAll());
        model.addAttribute("valgiarastis", valgiarastisService.findAll());
        model.addAttribute("patiekalas", patiekalasService.findAll());
        return "/admin-page";
    }

    @GetMapping("user-page")
    public String showUserPage(Model model) {
        model.addAttribute("istaiga", istaigaService.findAll());
//        model.addAttribute("valgiarastis", valgiarastisService.findAll());
//        model.addAttribute("patiekalas", patiekalasService.findAll());
        return "/user-page";
    }

    @GetMapping("/admin-page/showValgiarastisForm")
    public String showUpdateValgiarastisForm(@RequestParam("val_name") String name, Model model) {
        model.addAttribute("valgiarastis", valgiarastisService.findByName(name));
        model.addAttribute("istaiga", istaigaService.findAll());
        return "/update-valgiarastis";
    }

    @GetMapping("/admin-page/showIstaigaForm")
    public String showIstaigaUpdate(@RequestParam("ist_id") int id, Model model) {
        model.addAttribute("istaiga", istaigaService.fintById(id));
        return "/update-istaiga";
    }

    @GetMapping("/admin-page/showPatiekalasForm")
    public String showPatiekalasForm(@RequestParam("pat_id") int id, Model model) {
        model.addAttribute("patiekalas", patiekalasService.findById(id));
        model.addAttribute("valgiarastis", valgiarastisService.findAll());
        return "/update-patiekalas";
    }
}
