// Generated by Dagger (https://dagger.dev).
package me.taste2plate.app.customer.repo;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
import me.taste2plate.app.Woocommerce;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CategoryRepository_MembersInjector implements MembersInjector<CategoryRepository> {
  private final Provider<Woocommerce> woocommerceProvider;

  public CategoryRepository_MembersInjector(Provider<Woocommerce> woocommerceProvider) {
    this.woocommerceProvider = woocommerceProvider;
  }

  public static MembersInjector<CategoryRepository> create(
      Provider<Woocommerce> woocommerceProvider) {
    return new CategoryRepository_MembersInjector(woocommerceProvider);
  }

  @Override
  public void injectMembers(CategoryRepository instance) {
    injectWoocommerce(instance, woocommerceProvider.get());
  }

  @InjectedFieldSignature("me.taste2plate.app.customer.repo.CategoryRepository.woocommerce")
  public static void injectWoocommerce(CategoryRepository instance, Woocommerce woocommerce) {
    instance.woocommerce = woocommerce;
  }
}
