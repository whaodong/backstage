package com.whd.system.repository;

import com.whd.system.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
