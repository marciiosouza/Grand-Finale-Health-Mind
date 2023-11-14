using apiHealth.Model;
using Microsoft.EntityFrameworkCore;

namespace apiHealth.Context
{
    public class AppDbContext : DbContext
    {
        public DbSet<UsuarioModel> usuario { get; set; }
        public DbSet<MeditacaoModel> meditacao { get; set; }

        public AppDbContext(DbContextOptions options) : base(options) { }

        protected AppDbContext() { }

    }
}
