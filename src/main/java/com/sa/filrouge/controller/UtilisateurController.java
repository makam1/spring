package com.sa.filrouge.controller;

import com.sa.filrouge.modele.*;
import com.sa.filrouge.repository.CompteRepository;
import com.sa.filrouge.repository.DepotRepository;
import com.sa.filrouge.repository.PartenaireRepository;
import com.sa.filrouge.repository.UserRepository;
import com.sa.filrouge.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class UtilisateurController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PartenaireRepository partenaireRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private DepotRepository depotRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    private String fileBasePath;


    @GetMapping(value = "/liste")
  //  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Utilisateur> liste()
    {
        Utilisateur u= userDetailsService.getConnect();
        Partenaire part=u.getPartenaire();

        return  userRepository.findByPartenaire(part);

    }

    @GetMapping(value = "/partenaire/liste")
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public List<Partenaire> listePartenaire()
    {

        return partenaireRepository.findAll();

    }

    @PostMapping(value = "/admin",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public String add(@RequestParam("file") MultipartFile file,@ModelAttribute("user") Utilisateur user) {
        String num="Non alloué";
        Compte compte = compteRepository.findByNumerocompte(num);

        Utilisateur u= userDetailsService.getConnect();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatut("actif");
        user.setPartenaire(u.getPartenaire());
        Set<Role> roles = new HashSet<>();
        Role role= new Role();
        role.setId(5L);
        roles.add(role);
        user.setRoles(roles);
        user.setCompte(compte);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        user.setFileName(fileName);
        try {
            user.setImage(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(fileName).path("/db")
                .toUriString();

        String message="Admin ajouté avec succés";
         userRepository.save(user);
        return message;
    }

    @PostMapping(value = "/user",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String user(@RequestBody(required = false)Utilisateur user) {
        String num="Non alloué";
        Compte compte = compteRepository.findByNumerocompte(num);
        Utilisateur u= userDetailsService.getConnect();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatut("actif");
        user.setPartenaire(u.getPartenaire());
        Set<Role> roles = new HashSet<>();
        Role role= new Role();
        role.setId(6L);
        roles.add(role);
        user.setRoles(roles);
        user.setCompte(compte );
        String message="Utilisateur ajouté avec succés";
        userRepository.save(user);
        return message;
    }

    @PostMapping(value = "/caissier",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public String caissier(@RequestBody(required = false)Utilisateur user) {
        String num="Non alloué";
        Compte compte = compteRepository.findByNumerocompte(num);
        Utilisateur u= userDetailsService.getConnect();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatut("actif");
        user.setPartenaire(u.getPartenaire());
        Set<Role> roles = new HashSet<>();
        Role role= new Role();
        role.setId(7L);
        roles.add(role);
        user.setRoles(roles);
        user.setCompte(compte );
        String message="Caissier ajouté avec succés";
        userRepository.save(user);
        return message;
    }

    @PostMapping(value = "/adminpart",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public String partenaire(@RequestBody(required = false)Utilisateur user) {
        String num="Non alloué";
        Compte compte = compteRepository.findByNumerocompte(num);
        Utilisateur u= userDetailsService.getConnect();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatut("actif");
        user.setPartenaire(u.getPartenaire());
        Set<Role> roles = new HashSet<>();
        Role role= new Role();
        role.setId(8L);
        roles.add(role);
        user.setRoles(roles);
        user.setCompte(compte );
        String message="Admin partenaire ajouté avec succés";
        userRepository.save(user);
        return message;
    }

    @PostMapping(value = "/partenaire",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public String addPartenaire(@RequestBody PartenaireUtilisateur part) {


        Utilisateur u= userDetailsService.getConnect();
        Partenaire partenaire= new Partenaire();
        partenaire.setStatut("actif");
        partenaire.setRaisonsociale(part.getRaisonsociale());
        partenaire.setNinea(part.getNinea());
        partenaire.setAdresse(part.getAdresse());
        Compte compte= new Compte();
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        compte.setNumerocompte(format.format(date));
        compte.setPartenaire(partenaire);
        compte.setSolde(5000L);
        Utilisateur user= new Utilisateur();
        user.setUsername(part.getUsername());
        user.setName(part.getName());
        user.setTelephone(part.getTelephone());
        user.setEmail(part.getEmail());
        user.setPassword(encoder.encode(part.getPassword()));
        user.setStatut("actif");
        user.setPartenaire(partenaire);
        Set<Role> roles = new HashSet<>();
        Role role= new Role();
        role.setId(6L);
        roles.add(role);
        user.setRoles(roles);
        user.setCompte(compteRepository.compte("Non alloué"));

        partenaireRepository.save(partenaire);
        compteRepository.save(compte);
        userRepository.save(user);

        String message ="Partenaire, Compte et utilisateur associés ajouté avec succés";
        return message;
    }


    @PostMapping(value = "/bloquer",consumes = {MediaType.APPLICATION_JSON_VALUE})
  //  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String bloquer(@RequestBody(required = false)Utilisateur user) {

        String num=user.getEmail();
        Utilisateur u = userRepository.findByEmail(num);
        if(u.getStatut().equals("actif")==true){
            u.setStatut("bloqué");
            String message="Utilisateur bloqué";
            userRepository.save(u);
            return message;

        }
        u.setStatut("actif");
        String message="Utilisateur débloqué";
        userRepository.save(u);
        return message;
    }

}
