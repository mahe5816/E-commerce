package com.mahe.own.controller;
import java.awt.PageAttributes.MediaType;



import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mahe.own.res.prd;
import com.mahe.own.res.product;

@Controller
public class HomeController {
	@Autowired
	prd pr;
	@GetMapping("/")
	public String getHome() {
		return "index";
	}
	@GetMapping("/addp")
	public String home() {
		return "new";
	}
	
	@PostMapping(value = "/addcus")
	public String add(product p,@RequestParam("pname") String pname,
			@RequestParam("price") int price,Model m,@RequestParam("file") MultipartFile file) throws IOException {
		p.setPname(pname);
		p.setPrice(price);
	//	p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		p.setImgName(file.getOriginalFilename());
		p.setImgType(file.getContentType());
		p.setImageDate(file.getBytes());
		System.out.println(p);
		m.addAttribute("pp", p);
		pr.save(p);
		//return "redirect:'/addall'";
		//return new RedirectView("/addall");
		return "redirect:/addall";
	}
	@GetMapping("/img/{id}")
    public ResponseEntity<byte[]> image(@PathVariable int id) {
        Optional<product> p = pr.findById(id);
        if (p.isPresent()) {
            product pp = p.get();
            byte[] img = pp.getImageDate();  // Assuming getImageDate() is a typo and it should be getImageData()
            return ResponseEntity.ok()
                    .contentType(org.springframework.http.MediaType.valueOf(pp.getImgType()))
                    .body(img);
        } else {
            // Handle the case where the product is not found
            return ResponseEntity.notFound().build();
        }
    }
        @GetMapping("/addall")
        public String addall(Model m) {
        	List<product> ll=pr.findAll();
        	for(product s:ll)
        		System.out.print(s.getId()+""+s.getPname());
        	m.addAttribute("lis",ll);
        	return "all";
        }
 
}
