package android.company.coin.Data.Model.LogIn;

public class User {
        private Integer id;
        private String name;
        private String email;
        private Object emailVerifiedAt;
        private Integer authenticateState;
        private String authenticateStateName;
        private String createdAt;
        private String updatedAt;
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public Object getEmailVerifiedAt() {
            return emailVerifiedAt;
        }
        public void setEmailVerifiedAt(Object emailVerifiedAt) {
            this.emailVerifiedAt = emailVerifiedAt;
        }
        public Integer getAuthenticateState() {
            return authenticateState;
        }
        public void setAuthenticateState(Integer authenticateState) {
            this.authenticateState = authenticateState;
        }
        public String getAuthenticateStateName() {
            return authenticateStateName;
        }
        public void setAuthenticateStateName(String authenticateStateName) {
            this.authenticateStateName = authenticateStateName;
        }
        public String getCreatedAt() {
            return createdAt;
        }
        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }
        public String getUpdatedAt() {
            return updatedAt;
        }
        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }

