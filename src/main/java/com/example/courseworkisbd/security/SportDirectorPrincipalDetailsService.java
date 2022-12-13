package com.example.courseworkisbd.security;

import com.example.courseworkisbd.entities.SportDirector;
import com.example.courseworkisbd.repositories.SportDirectorRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class SportDirectorPrincipalDetailsService implements UserDetailsService {
    private SportDirectorRepository sportDirectorRepository;

    public SportDirectorPrincipalDetailsService(SportDirectorRepository userRepository) {
        this.sportDirectorRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SportDirector user = this.sportDirectorRepository.findByUsername(s);
        SportDirectorPrincipal userPrincipal = new SportDirectorPrincipal(user);

        return userPrincipal;
    }
}