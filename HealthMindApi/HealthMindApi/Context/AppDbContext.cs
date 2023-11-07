using apiHealthMind.Model;
using Microsoft.EntityFrameworkCore;

namespace apiHealthMind.Context
{
    public class AppDbContext : DbContext
    {
        

        public DbSet<UsuarioModel> usuario { get; set; }

        public AppDbContext(DbContextOptions options) : base(options) { }

        protected AppDbContext() { }


    }
    

    
}
