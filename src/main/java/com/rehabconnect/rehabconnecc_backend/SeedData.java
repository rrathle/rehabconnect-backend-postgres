package com.rehabconnect.rehabconnecc_backend;

import com.rehabconnect.rehabconnecc_backend.model.RehabPlan;
import com.rehabconnect.rehabconnecc_backend.repository.RehabPlanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SeedData {

    @Bean
    public CommandLineRunner seedDatabase(RehabPlanRepository rehabPlanRepository) {
        return args -> {
            System.out.println("🌱 CommandLineRunner started");

            boolean isEmpty = rehabPlanRepository.findAll().isEmpty();
            System.out.println("Is DB empty? " + isEmpty);

            if (isEmpty) {
                System.out.println("🌱 Seeding rehab plan...");
                RehabPlan plan = new RehabPlan();
                plan.setPatientId("seed123");
                plan.setGoals("Initial seed plan: Reduce pain and improve strength.");
                plan.setExercises(Arrays.asList("Clamshell", "Leg Raises", "Hip Bridge"));

                rehabPlanRepository.save(plan);
                System.out.println("✅ Seeded RehabPlan to DB.");
            } else {
                System.out.println("ℹ️ DB already has data. Skipping seed.");
            }
        };
    }
}
